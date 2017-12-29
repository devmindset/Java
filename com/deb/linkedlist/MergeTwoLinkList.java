package com.deb.linkedlist;

import java.util.LinkedList;



public class MergeTwoLinkList {

	public static void main(String args[]){
	LinkedList<Integer> list1 = new LinkedList<Integer>();
    LinkedList<Integer> list2 = new LinkedList<Integer>();
    LinkedList<Integer> sortedList = new LinkedList<Integer>();
    list1.add(1);
    list1.add(3);
    list1.add(5);
    list1.add(7);
    list1.add(9);

    list2.add(2);
    list2.add(4);
    list2.add(6);
    list2.add(8);
    list2.add(10);

    while (!list1.isEmpty() && !list2.isEmpty())
    {
        Integer first1 = list1.getFirst();
        Integer first2 = list2.getFirst();

        if(first1 < first2)
        {
            sortedList.add(first1);
            list1.removeFirst();
        }
        else if(first2 > first1)
        {
            sortedList.add(first2);
            list2.removeFirst();
        }
        else // if first1 == first2 then default to first1
        {
            sortedList.add(first1);
            list1.removeFirst();
        }
    }

    for (Integer i : list1) // add any remaining values from list1
        sortedList.add(i);

    for (Integer i : list2) // add any remaining values from list2
        sortedList.add(i);

    for (Integer i : sortedList) // print the sorted list
        System.out.println(i);
}
}