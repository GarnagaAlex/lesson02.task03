/*
 * Copyright (C) 2020 ;)
 */

package com.garnagaaa.lesson02.task03.app1;

import com.garnagaaa.lesson02.task03.app1.core.Person;
import com.garnagaaa.lesson02.task03.app1.core.PersonManager;
import com.garnagaaa.lesson02.task03.app1.core.exception.NameEq;
import com.garnagaaa.lesson02.task03.app1.core.generator.PersonGenerator;
import com.garnagaaa.lesson02.task03.app1.core.sortable.*;

/**
 * @author Aleksei Garnaga
 */
public class Program {
    public static void main(String[] args) throws NameEq {

        long alg1;
        long alg2;

        Person[] data = PersonGenerator.generateArrPerson(20, true);
        Person[] data2 = PersonManager.personCloneArr(data);

        PersonManager PM = new PersonManager(new SortVersion1(), data);
        PM.sort().showToConsole();
        alg1 = PM.getLeadTime();

        System.out.println();

        PM = new PersonManager(new SortVersion2(), data2);
        PM.sort().showToConsole();
        alg2 = PM.getLeadTime();

        System.out.println();

        System.out.println("LeadTime SortVersion1 (Sorting by bubble): " + alg1 + "ms");
        System.out.println("LeadTime SortVersion2 (The insertion sort): " + alg2 + "ms");

    }
}