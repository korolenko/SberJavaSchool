package com.company.Homework3;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class GetCollectionClass {

    private List<Cat> catList = new ArrayList<>();

    public static void getCollection() throws NoSuchFieldException {
        //get collection generic type
        System.out.println("collection generic type:");
        Field stringListField = GetCollectionClass.class.getDeclaredField("catList");
        ParameterizedType stringListType = (ParameterizedType) stringListField.getGenericType();
        Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
        System.out.println(stringListClass);
    }
}
