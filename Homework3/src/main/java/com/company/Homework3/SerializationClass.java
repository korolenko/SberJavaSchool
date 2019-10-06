package com.company.Homework3;

import java.io.*;

public class SerializationClass {
    public static void serialization() throws IOException, ClassNotFoundException {
        System.out.println("The 1 part: serilization");
        Cat cat1 = new Cat(1,"Васька");

        //serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(cat1);
        ous.close();
        System.out.println("The object has been serialized");

        //deserialize
        ByteArrayInputStream bios = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bios);
        Cat cloneCat1 = (Cat)ois.readObject();

        System.out.println("The object has been deserialized");
        System.out.println("the original object: " + cat1.toString());
        System.out.println("the cloned object: " + cloneCat1.toString());
        System.out.println("==: " + (cat1==cloneCat1));
        System.out.println("equals: " + cat1.equals(cloneCat1));
    }
}
