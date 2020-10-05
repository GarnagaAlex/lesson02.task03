package com.garnagaaa.lesson02.task03.app1.core.exception;

/**
 * @author Aleksei Garnaga
 * Исключение возникающее в случае попытки вставки одинаковых персонажей
 */
public class NameEq extends Exception {
    public NameEq() {
        super("NameEq");
    }
}
