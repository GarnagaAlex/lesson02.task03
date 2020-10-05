package com.garnagaaa.lesson02.task03.app1.core.sortable;

import com.garnagaaa.lesson02.task03.app1.core.Person;

/**
 * @author Aleksei Garnaga
 * Класс сортировки вставками
 */
public class SortVersion2 implements ISortablePerson {

    public void sort(Person[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Person current = arr[i];
            int j = i - 1;
            while(j >= 0 &&  current.getIndex().compareTo(arr[j].getIndex())==1) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
}
