package com.garnagaaa.lesson02.task03.app1.core.sortable;

import com.garnagaaa.lesson02.task03.app1.core.Person;

/**
 * @author Aleksei Garnaga
 * Класс сортировки пузырьком
 */
public class SortVersion1 implements ISortablePerson {

    public void sort(Person[] arr) {
        boolean sorted = false;
        Person temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].getIndex().compareTo(arr[i+1].getIndex())==-1) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
