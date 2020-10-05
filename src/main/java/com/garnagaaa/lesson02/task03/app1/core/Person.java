package com.garnagaaa.lesson02.task03.app1.core;

import com.garnagaaa.lesson02.task03.app1.core.enums.Sex;
import com.garnagaaa.lesson02.task03.app1.core.exception.AgeExceptionBase;
import com.garnagaaa.lesson02.task03.app1.core.exception.NameBasePersonException;
import java.math.BigInteger;

/**
 * @author Aleksei Garnaga
 * Модель персонажа
 */
public class Person {
    private byte age;           // Возраст
    private Sex sex;            // Пол
    private String name;        // Имя
    private BigInteger index;   // Индекс

    /**
     * Метод получения возраста
     * @return Возраст
     */
    public byte getAge() {
        return age;
    }

    /**
     * Метод установки возраста
     * @param age возраст
     * @throws AgeExceptionBase Исключение по возрасту
     */
    private void setAge(byte age) throws AgeExceptionBase {
        if (age >= 0 && age <= 100) {
            this.age = age;
        } else {
            throw new AgeExceptionBase(String.valueOf(age));
        }
    }

    /**
     * Метод получения пола
     * @return Пол персонажа
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Метод установки пола персонажа
     * @param sex Пол персонажа
     */
    private void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Метод получения имени персонажа
     * @return Имя пресонажа
     */
    public String getName() {
        return name;
    }

    /**
     * Метод установки имени персонажа
     * @param name Имя персонажа
     * @throws NameBasePersonException Исключение по имени пресонажа...
     */
    private void setName(String name) throws NameBasePersonException {
        if (name != null && !name.equalsIgnoreCase("") && name.length() <= 128) {
            this.name = name;
        } else {
            throw new NameBasePersonException();
        }
    }

    /**
     * Конструктор
     * @param age Возраст
     * @param sex Пол
     * @param name Имя
     * @throws AgeExceptionBase Ошибка возраста
     * @throws NameBasePersonException Ошибка имени пресонажа
     */
    public Person(byte age, Sex sex, String name) throws AgeExceptionBase, NameBasePersonException {
        setAge(age);
        setSex(sex);
        setName(name);

        //Generate index
        generateIndex();
    }

    /**
     * Метод получения индекса для сортировки
     * @return Индекс
     */
    public BigInteger getIndex() {
        return index;
    }

    /**
     * Метод установки индекса
     * @param index Индекс
     */
    private void setIndex(BigInteger index) {
        this.index = index;
    }

    /**
     * Перегрузка для toString
     * @return Форматированная строка
     */
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Метод генерации индекса для объекта
     */
    private void generateIndex() {
        StringBuilder temp = new StringBuilder();

        if (getSex() == Sex.MAN) {
            temp.append("2");
        } else {
            temp.append("1");
        }

        temp.append(String.format("%03d", getAge()));

        for (int i = 0; i < getName().length(); i++) {
            int charId = getName().toLowerCase().charAt(i);
            // invert
            charId = 999 - charId;
            temp.append(String.format("%03d", charId));
        }

        // final string len 128*3 + 1 + 3 = 388
        // 128 = длина имени
        // 3 = кол во по маске
        // 1 = пол
        // 3 = возвраст
        int finStrLength = (128 * 3) + 1 + 3;
        int tempLength = temp.length();
        if (tempLength < finStrLength) {
            for (int i = 0; i < finStrLength - tempLength; i++) {
                temp.append("0");
            }
        }
        setIndex(new BigInteger(temp.toString()));
    }
}
