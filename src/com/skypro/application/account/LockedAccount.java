package com.skypro.application.account;
// будет происходить добавление в массив локедаккаунт на самое первое место
public class LockedAccount extends Account {

    public static String[] LOKED_ACCOUTS = new String[3];// с человеком можно проводить только одну операцию
    public LockedAccount(String name, int balace) {
        super(name, balace);
        LOKED_ACCOUTS[0]= name;
    }
}
