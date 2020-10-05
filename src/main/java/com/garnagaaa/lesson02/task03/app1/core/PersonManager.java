package com.garnagaaa.lesson02.task03.app1.core;

import com.garnagaaa.lesson02.task03.app1.core.exception.AgeExceptionBase;
import com.garnagaaa.lesson02.task03.app1.core.exception.NameBasePersonException;
import com.garnagaaa.lesson02.task03.app1.core.sortable.ISortablePerson;

/**
 * @author Aleksei Garnaga
 * Менеджер персонажей
 */
public class PersonManager {

    private final ISortablePerson sortAlg;  // Метод сортировки
    private Person[] data;                  // Массив персонажей
    private long leadTime;                  // Время выполнения


    /**
     * Конструктор
     * @param sortAlg   Метод сортировки
     * @param data      Данные
     */
    public PersonManager(ISortablePerson sortAlg, Person[] data) {
        this.sortAlg = sortAlg;
        this.data = data;
    }

    /**
     * Метод запуска сортировки
     * @return PersonManager
     */
    public PersonManager sort() {
        long start = System.currentTimeMillis();
        sortAlg.sort(data);
        long finish = System.currentTimeMillis();
        leadTime = finish - start;
        return this;
    }

    /**
     * Метод вывода данных на консоль
     */
    public void showToConsole() {
        for (Person datum : data) {
            System.out.println(datum.toString());
        }
    }

    /**
     * Метод получения времени выполнения
     * @return Время работы алгоритма
     */
    public long getLeadTime() {
        return leadTime;
    }

    /**
     * Метод глубокого клонирования массива персонажей
     * @param data Данные
     * @return Копия
     */
    public static Person[] personCloneArr(Person[] data) {
        Person[] temp = new Person[data.length];
        for (int i = 0; i < data.length; i++) {
            try {
                temp[i] = new Person(data[i].getAge(), data[i].getSex(), data[i].getName());
            } catch (AgeExceptionBase ageExceptionBase) {
                ageExceptionBase.printStackTrace();
            } catch (NameBasePersonException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }
}
