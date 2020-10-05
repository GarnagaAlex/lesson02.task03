package com.garnagaaa.lesson02.task03.app1.core.exception;

/**
 * @author Aleksei Garnaga
 * Исключение ограничения связанные с длиной имени или значением NULL
 */
public class NameBasePersonException extends BasePersonException {
    public NameBasePersonException() {
        super("Person name is null or empty or length > 128");
    }
}
