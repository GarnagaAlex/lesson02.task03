package com.garnagaaa.lesson02.task03.app1.core.generator;

import com.garnagaaa.lesson02.task03.app1.core.enums.Sex;

import java.util.Random;

/**
 * @author Aleksei Garnaga
 *
 * Утильный класс генератор свойств персонажей
 */
public final class UserDataGenerate {

    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final int MAXLengthName = 15;
    private static final int MINLengthName = 5;

    /**
     * Генератор имени персонажа
     *
     * @return Имя перонажа
     */
    public static String generateName() {
        int length = RandomArrGenerator(MAXLengthName, MINLengthName, 1)[0];
        int[] name = RandomArrGenerator(ALPHABET.length - 1, 0, length);
        StringBuilder sb = new StringBuilder();
        for (int j : name) {
            sb.append(ALPHABET[j]);
        }
        return sb.toString();
    }

    /**
     * Генератор возраста
     *
     * @return Возраст персонажа от 0 до 100
     */
    public static int generateAge() {
        return RandomArrGenerator(101, 0, 1)[0];
    }

    /**
     * Генератор пола персонажа
     *
     * @return Пол персонажа
     */
    public static Sex sexGenerator() {
        // ;)
        int id = RandomArrGenerator(2, 0, 1)[0];
        if (id == 0) {
            return Sex.MAN;
        } else {
            return Sex.WOMAN;
        }
    }

    /**
     * Генератор массива случайных чисел (RAG)
     *
     * @param max   Максимальное число
     * @param min   Минимальное число
     * @param count Кол-во чисел в массива
     * @return int[] Массив случайных чисел
     */
    private static int[] RandomArrGenerator(int max, int min, int count) {
        Random rd = new Random();
        int[] temp = new int[count];
        for (int i = 0; i < count; i++) {
            temp[i] = rd.nextInt(max - min) + min;
        }
        return temp;
    }
}
