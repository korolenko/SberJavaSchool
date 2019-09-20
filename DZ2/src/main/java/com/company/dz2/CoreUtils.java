package com.company.dz2;

import java.util.*;

/*
класс обработчик основной логики приложения
 */
public class CoreUtils {

    //список девайсов
    private ArrayList<Device> deviceList = new ArrayList<>();
    private Event event;
    //список событий
    private LinkedList<Event> eventList = new LinkedList<>();

    public int getDeviceListSize(){
        return this.deviceList.size();
    }

    // динамическое создание объектов
    public void createDevice(int id) throws InputMismatchException{
        ArrayList<Component> componentList = new ArrayList<>();
        System.out.println("Enter device name:..");
        Scanner in = new Scanner(System.in);
        String deviceName = in.nextLine();
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

    public void showDevice() throws InputMismatchException{
        if(getDeviceListSize() < 1){
            System.out.println("Create devices!");
        }
        else {
            System.out.println("Enter device id (from 0 to " + (getDeviceListSize() -1) + "):..");
            Scanner deviceIdScanner = new Scanner(System.in);
            deviceList.get(deviceIdScanner.nextInt()).showDeviceInfo();
        }
    }
    //генерация очереди объектов
    public void createEvents() throws InputMismatchException{
        if(getDeviceListSize() < 1){
            System.out.println("Create devices!");
        }
        else {
            int eventsNumber;
            int check;
            int devicesNumber;
            int componentsNumber;
            int deviceId;
            int componentId;

            System.out.println("Enter number of events:..");
            Scanner eventNumberScanner = new Scanner(System.in);
            eventsNumber = eventNumberScanner.nextInt();
            devicesNumber = deviceList.size();
            this.eventList.clear();

            //генерация случайных deviceId и componentId,
            //но только в пределах созданных девайсов и их компонентов
            //для случайных errorEvent и restoreEvent
            Random eventRandom = new Random();
            Random deviceRandom = new Random();
            Random componentRandom = new Random();

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Generated events:");
            for (int i = 0; i < eventsNumber; i++) {
                check = eventRandom.nextInt(2);
                switch (check) {
                    case (0): {
                        deviceId = deviceRandom.nextInt(devicesNumber);
                        componentsNumber = this.deviceList.get(deviceId).getComponentsNumber();
                        componentId = componentRandom.nextInt(componentsNumber);
                        this.event = new ErrorEvent(deviceId, componentId);
                        System.out.println(i + ") errorEvent, deviceid: " + deviceId + ", " +
                                "componentid: " + componentId);
                        break;
                    }
                    case (1): {
                        deviceId = deviceRandom.nextInt(devicesNumber);
                        componentsNumber = this.deviceList.get(deviceId).getComponentsNumber();
                        componentId = componentRandom.nextInt(componentsNumber);
                        this.event = new RestoreEvent(deviceId, componentId);
                        System.out.println(i + ") restoreEvent, deviceid: " + deviceId + ", " +
                                "componentid: " + componentId);
                        break;
                    }
                }
                eventList.add(event);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            //запускаем изменения объектов
            setComponentStatus();
        }
    }

    private Device getDevice(int deviceId){
        return this.deviceList.get(deviceId);
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
                getDevice(deviceId).getComponent(componentid).setStatus(false);
                getDevice(deviceId).setDeviceState();
            }
            else if (event instanceof RestoreEvent){
                getDevice(deviceId).getComponent(componentid).setStatus(true);
                getDevice(deviceId).setDeviceState();
            }
        }
    }
}
