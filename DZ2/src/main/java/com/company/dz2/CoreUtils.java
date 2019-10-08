package com.company.dz2;

import com.company.dz2.device.Component;
import com.company.dz2.device.Device;
import com.company.dz2.events.ErrorEvent;
import com.company.dz2.events.Event;
import com.company.dz2.events.RestoreEvent;
import com.company.dz2.factory.ErrorEventFactory;
import com.company.dz2.factory.RestoreEventFactory;

import java.util.*;

/*
класс обработчик основной логики приложения
 */
public class CoreUtils {

    //список девайсов
    private List<Device> deviceList = new ArrayList<>();
    //список событий
    private List<Event> eventList = new LinkedList<>();

    public int getDeviceListSize(){
        return this.deviceList.size();
    }

    // динамическое создание объектов
    public void createDevice(int id) throws InputMismatchException{
        
        //создаем девайс
        System.out.println("Enter device name:..");
        Scanner in = new Scanner(System.in);
        String deviceName = in.nextLine();
        
        //создаем компоненты девайса
        System.out.println("Enter number of components:..");
        int componentsNumber = in.nextInt();
        
        Device device = new Device(id,deviceName,createComponents(componentsNumber));
        this.deviceList.add(device);
    }

    private List<Component> createComponents(int componentsNumber){
        String componentName;
        boolean componentStatus;
        List<Component> componentList = new ArrayList<>();

        for(int i = 0; i<componentsNumber; i++){
            System.out.println("Enter component name:..");
            Scanner componentScanner = new Scanner(System.in);
            componentName = componentScanner.nextLine();
            System.out.println("Enter component status ('true' or 'false'):..");
            componentStatus = componentScanner.nextBoolean();
            Component component = new Component(i,componentName,componentStatus);
            componentList.add(component);
        }
        return componentList;
    }

    public void showDevice() throws InputMismatchException {
        if (getDeviceListSize() < 1) {
            System.out.println("Create devices!");
        } else {
            System.out.println("Enter device id (from 0 to " + (getDeviceListSize() - 1) + "):..");
            Scanner deviceIdScanner = new Scanner(System.in);
            deviceList.get(deviceIdScanner.nextInt()).showDeviceInfo();
        }
    }

    //генерация очереди объектов
    public void createEvents() throws InputMismatchException{
        if(this.deviceList.size()>0) {
            int eventType;
            int devicesNumber;
            int componentsNumber;
            int deviceId;
            int componentId;
            int eventsNumber;
            Event event = null;
            devicesNumber = deviceList.size();

            this.eventList.clear();

            Random eventRandom = new Random();
            Random deviceRandom = new Random();
            Random componentRandom = new Random();

            ErrorEventFactory errorEventFactory = new ErrorEventFactory();
            RestoreEventFactory restoreEventFactory = new RestoreEventFactory();

            System.out.println("Enter events number:..");
            Scanner in = new Scanner(System.in);
            eventsNumber = in.nextInt();
                if (eventsNumber > 0) {
                    //генерация случайных deviceId и componentId,
                    //но только в пределах созданных девайсов и их компонентов
                    //для случайных errorEvent и restoreEvent
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Generated events:");
                    for (int i = 0; i < eventsNumber; i++) {
                        //получаем тип события
                        eventType = eventRandom.nextInt(2);
                        //получаем deviceId
                        deviceId = deviceRandom.nextInt(devicesNumber);
                        //получаем количество компонентов девайса и нужный componentId
                        componentsNumber = this.deviceList.get(deviceId).getComponentsNumber();
                        componentId = componentRandom.nextInt(componentsNumber);

                        //создаем события, логируем процесс создания
                        switch (eventType) {
                            case (0): {
                                event = errorEventFactory.createEvent(deviceId, componentId);
                                EventInfo(i, "errorEvent", deviceId, componentId);
                                break;
                            }
                            case (1): {
                                event = restoreEventFactory.createEvent(deviceId, componentId);
                                EventInfo(i, "restoreEvent", deviceId, componentId);
                                break;
                            }
                        }
                        eventList.add(event);
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    setComponentStatus();
                }
        }else {
            System.out.println("create devices!");
        }
    }

    private void EventInfo(int counter,String event, int deviceId, int componentId){
        System.out.println(counter + ") " + event + ", deviceid: " + deviceId + ", " +
                "componentid: " + componentId);
    }

    //данный блок кода вынесен в функцию во избежание дублирования
    private void setComponentStatus(boolean status, int deviceId, int componentid){
        // меняем статус компонента
        this.deviceList.get(deviceId).getComponent(componentid).setStatus(status);
        //пересчитываем состояние девайса
        this.deviceList.get(deviceId).setDeviceState();
    }
    
    //метод обработки очереди событий, преобразования объектов
    private void setComponentStatus(){
        int deviceId;
        int componentid;
        Event event;
        ListIterator<Event> eventIterator = eventList.listIterator();

        //обходим лист событий, меняем статусы компонентам, пересчитываем состояние девайса
        while (eventIterator.hasNext()){
            event = eventIterator.next();
            deviceId = event.getDeviceId();
            componentid = event.getComponentId();
            
            if (event instanceof ErrorEvent) {
                setComponentStatus(false,deviceId,componentid);
            }
            else if (event instanceof RestoreEvent){
                setComponentStatus(true,deviceId,componentid);
            }
        }
    }
}

