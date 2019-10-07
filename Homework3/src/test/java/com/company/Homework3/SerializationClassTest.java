package com.company.Homework3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class SerializationClassTest {
    private Cat cat;

    @Before
    public void createCat(){
        cat = new Cat(2,"Мурзик");
    }

    @Test
    public void serialization() throws IOException, ClassNotFoundException {
        byte[] serialized1 = serialize(cat);
        byte[] serialized2 = serialize(cat);

        Object deserialized1 = deserialize(serialized1);
        Object deserialized2 = deserialize(serialized2);
        Assert.assertEquals(deserialized1, deserialized2);
        Assert.assertEquals(cat, deserialized1);
        Assert.assertEquals(cat, deserialized2);
    }

    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }
    private static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
}