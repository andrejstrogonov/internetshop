package org.skypro.skyshop.search.engine;

public class BestResultNotFound  extends Exception{
    /**
     * Конструктор класса.
     *
     * @param message сообщение об ошибке
     */
    public BestResultNotFound(String message) {
        super(message);
    }
}
