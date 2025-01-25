package com.skypro.application.account; // создали новый пакет аккаунт, новый класс Аккаунт

import com.skypro.application.errors.PersonalInfoExceptoin;
import com.skypro.application.errors.TransactionException;

public class Account {
    protected String name;
    protected int balace;

    public Account(String name, int balace) {// конструтктор
        if (name == null) {
            throw new PersonalInfoExceptoin(); // тогда теперь в майн можно написать...
        }
        this.name = name;
        this.balace = balace;
    }

    public String getName() {
        return name;
    }

    public int getBalace() {
        return balace;
    }

    public void setBalace(int balace) {
        this.balace = balace;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balace=" + balace +
                '}';
    }

    public void changeBalance(int amount) { //метод
        if (balace + amount < 0) {
            throw new TransactionException(name); // пишем свое исключение, а внутри имя человека у кот нету денег
        }
        balace=balace+amount;
    }
}
