package com.garnagaaa.lesson02.task03.app1.core.exception;

/**
 * @author Aleksei Garnaga
 * Исключение ограничения по возврату
 */
public class AgeExceptionBase extends BasePersonException {
    public AgeExceptionBase(String message) {
        super("Age restrictions. Age = " + message);
    }
}
