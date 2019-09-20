package com.company.dz2;

public class Component {
    private int id;
    private String name;
    private boolean status;

    public Component(int id, String name, boolean status){
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public void setStatus(boolean status){
        if (this.status != status) {
            this.status = status;
        }
    }

    public boolean getStatus() {
        return status;
    }

    public String toString(){
        return "Component " + this.name + " info:\n" +
                "id: " + this.id + "\n" +
                "status: " + this.status;
    }
}
