package com.skypro.application.errors; // создали новый пакет application.errors;

public class TransactionException extends RuntimeException { // новый класс, и пусть он наследуется от непроверяемых рантайм
private String name;

    public TransactionException(String name) {
              this.name = name;
    }

    @Override
    public String toString() {
        return "Ошибка транзакции: у " + name + " нет денег!!!!!";
    }
}
