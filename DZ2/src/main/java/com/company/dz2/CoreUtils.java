package com.company.dz2;

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
        List<Component> componentList = new ArrayList<>();
        System.out.println("Enter device name:..");
        Scanner in = new Scanner(System.in);
        String deviceName = in.nextLine();
        
        //создаем компоненты девайса
        System.out.println("Enter number of components:..");
        int componentsNumber = in.nextInt();
        String componentName;
        boolean componentStatus;
        for(int i = 0; i<componentsNumber; i++){
            System.out.println("Enter component name:..");
            Scanner componentScanner = new Scanner(System.in);
            componentName = componentScanner.nextLine();
            System.out.println("Enter component status ('true' or 'false'):..");
            componentStatus = componentScanner.nextBoolean();
            Component component = new Component(i,componentName,componentStatus);
            componentList.add(component);
        }
        
        Device device = new Device(id,deviceName,componentList);
        this.deviceList.add(device);
    }

    private void EventInfo(int counter,String event, int deviceId, int componentId){
        System.out.println(counter+") " + event + ", deviceid: " + deviceId + ", " +
                "componentid: " + componentId);
    }

    //данный блок кода вынесен в функцию во избежание дублирования
    private void setComponentStatus(boolean status, int deviceId, int componentid){
        // меняем статус компонента
        this.deviceList.get(deviceId).getComponent(componentid).setStatus(status);
        //пересчитываем состояние девайсв
        this.deviceList.get(deviceId).setDeviceState();
    }

    public void showDevice(int id){
         this.deviceList.get(id).showDeviceInfo();
    }
    //генерация очереди объектов
    public void createEvents(int eventsNumber) throws InputMismatchException{
        int eventType;
        int devicesNumber;
        int componentsNumber;
        int deviceId;
        int componentId;
        Event event = null;
        devicesNumber = deviceList.size();

        this.eventList.clear();
        Random eventRandom = new Random();
        Random deviceRandom = new Random();
        Random componentRandom = new Random();

        //генерация случайных deviceId и componentId,
        //но только в пределах созданных девайсов и их компонентов
        //для случайных errorEvent и restoreEvent
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Generated events:");
        for (int i = 0; i<eventsNumber; i++){
            //получаем тип события
            eventType = eventRandom.nextInt(2);
            //получаем deviceId
            deviceId = deviceRandom.nextInt(devicesNumber);
            //получаем количество компонентов девайса и нужный componentId
            componentsNumber = this.deviceList.get(deviceId).getComponentsNumber();
            componentId = componentRandom.nextInt(componentsNumber);

            switch (eventType ){
                case (0):{
                    event = new ErrorEvent(deviceId, componentId);
                    EventInfo(i,"errorEvent",deviceId,componentId);
                    break;
                }
                case (1):{
                    event = new RestoreEvent(deviceId, componentId);
                    EventInfo(i,"restoreEvent",deviceId,componentId);
                    break;
                }
            }
            eventList.add(event);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        setComponentStatus();
    }

    //обработка очереди, преобразование объектов
    public void setComponentStatus(){
        int deviceId;
        int componentid;
        Event event;
        ListIterator<Event> eventIterator = eventList.listIterator();

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

