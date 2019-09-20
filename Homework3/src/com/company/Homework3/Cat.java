package com.company.Homework3;

import java.io.Serializable;

public class Cat implements Serializable {
    private int id;
    private String name;

    Cat(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "id: " + this.id + "; name = " + this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cat cat = (Cat)obj;
        return this.id==cat.id && this.name.equals(cat.name);
    }
}

