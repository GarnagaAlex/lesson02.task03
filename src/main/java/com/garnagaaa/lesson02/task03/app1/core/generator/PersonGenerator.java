package com.garnagaaa.lesson02.task03.app1.core.generator;

import com.garnagaaa.lesson02.task03.app1.core.Person;
import com.garnagaaa.lesson02.task03.app1.core.enums.Sex;
import com.garnagaaa.lesson02.task03.app1.core.exception.AgeExceptionBase;
import com.garnagaaa.lesson02.task03.app1.core.exception.NameBasePersonException;
import com.garnagaaa.lesson02.task03.app1.core.exception.NameEq;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksei Garnaga
 * Утильный класс генератор персонажей
 */
public final class PersonGenerator {

    /**
     * @param count Кол-во персонажей
     * @param enableUnique Необходимость проверки дублей персонажей
     * @return Массив персонажей
     */
    public static Person[] generateArrPerson(int count, boolean enableUnique) throws NameEq {
        Map<String, Person> mapPerson = new HashMap<String, Person>();
        for (int i = 0; i < count; i++) {

            String name = UserDataGenerate.generateName();
            int age = UserDataGenerate.generateAge();
            Sex sex = UserDataGenerate.sexGenerator();

            if(enableUnique) {
                if (!mapPerson.containsKey(name + age)) {
                    try {
                        mapPerson.put(name + age, new Person((byte) age, sex, name));
                    } catch (AgeExceptionBase ageExceptionBase) {
                        ageExceptionBase.printStackTrace();
                    } catch (NameBasePersonException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new NameEq();
                }
            }else{
                try {
                    mapPerson.put(name + age, new Person((byte) age, sex, name));
                } catch (AgeExceptionBase ageExceptionBase) {
                    ageExceptionBase.printStackTrace();
                } catch (NameBasePersonException e) {
                    e.printStackTrace();
                }
            }
        }
        return mapPerson.values().toArray(new Person[0]);
    }
}
