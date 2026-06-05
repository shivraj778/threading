package collection;

import java.util.ArrayList;
import java.util.Objects;

public class ListTesting {
    public static void main(String[] args) {
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

        //thirdList.forEach(System.out::println);

        Object[] objectArray =  thirdList.toArray();
        Integer[] integersArray = thirdList.toArray(new Integer[0]);
        for (Integer i: integersArray) {
            System.out.println(i);
        }
    }
}
