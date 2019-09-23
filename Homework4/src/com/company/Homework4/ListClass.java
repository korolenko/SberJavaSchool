package com.company.Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.stream.Collectors;

public class ListClass {
    private List<Integer> exampleList;

    ListClass(){
        this.exampleList = generate();
    }

    private List<Integer> generate(){
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i< 100; ++i){
            Random rnd = new Random();
            if(rnd.nextBoolean()){
                values.add(255);
            }
            else{
                values.add(rnd.nextInt(255));
            }
        }
        return values;
    }
    void deleteWithStream(){
        List<Integer> deletedList = this.exampleList.stream()
                .filter(s -> !s.equals(255))
                .collect(Collectors.toList());
        System.out.println(deletedList.size());
        this.exampleList.clear();
        this.exampleList = deletedList;

        //плюс короткий вариант
        //exampleList.removeIf(element -> element.equals(255));
    }
    void deleteWitoutStream(){

        ListIterator<Integer> listIterator = exampleList.listIterator();
        while (listIterator.hasNext()){
            Integer element = listIterator.next();
            if(element.equals(255)){
                listIterator.remove();
            }
        }
        //плюс другой способ
        /*List<Integer> deletedList = new ArrayList<>();
        for (int i = 0; i < exampleList.size()-1; i++){
            if(!exampleList.get(i).equals(255)){
                deletedList.add(exampleList.get(i));
            }
        }
        this.exampleList.clear();
        this.exampleList = deletedList;*/
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<this.exampleList.size(); i++){
            stringBuilder.append(exampleList.get(i) + ", ");
        }
        return stringBuilder.toString();
    }
}
