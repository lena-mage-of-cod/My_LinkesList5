package ru.first;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {
        List<String> list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.add(0, "a");
        list.add(1, "b");
        list.add(2, "c");
        list.add(3, "d");
        list.add(4, "e");

        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        //  System.out.println(list.get(3));
        System.out.println("---");
        System.out.println(Collections.binarySearch(list, "b"));
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        Collections.reverse(list);
        it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
        Collections.swap(list, 2, 4);
        it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        Collections.addAll(list,"plus","plus","plus");
        System.out.println();
        System.out.println(list.contains("plus"));
        System.out.println(Collections.frequency(list,"plus"));


    }
}











