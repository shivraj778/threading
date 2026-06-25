package collection;

import datastructure.linkedlist.LinkedList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ListTesting {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        var firstList = new ArrayList<Integer>();
        var secondList = new ArrayList<Integer>(firstList);
        var thirdList = new ArrayList<>(3);

        firstList.add(1);
        firstList.add(2);
        thirdList.add(1);
        thirdList.add(2);
        thirdList.add(1);
        thirdList.add(2);

        //secondList.forEach(System.out::println);

        thirdList.forEach(System.out::println);

        Object[] objectArray =  thirdList.toArray();
//        Integer[] integersArray = thirdList.toArray(new Integer[0]);
//        for (Integer i: integersArray) {
//            System.out.println(i);
//        }


       Class<?> class1= Class.forName("collection.A");
       Constructor<?> constructor = class1.getDeclaredConstructor(int.class,int.class);
        Method method = class1.getDeclaredMethod("getI");
       constructor.setAccessible(true);
       Object objects = constructor.newInstance(10,20);

        Object a = method.invoke(objects);
        System.out.println((int)a);



    }
}

class A {
    private int i,j;
    A(){}
    private A(int i,int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i+j;
    }
}
