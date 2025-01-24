package com.skypro;

import com.skypro.application.account.Account;
import com.skypro.application.account.LockedAccount;
import com.skypro.application.errors.PersonalInfoExceptoin;
import com.skypro.application.errors.TransactionException;

import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;

public class JavaProMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Skypro Uni - Java Professional start!");
        try {
            busineseException();
        } catch (TransactionException e) {
            System.out.println("сaught (поймали) TransactionException");
        } catch (PersonalInfoExceptoin e) {
            throw new RuntimeException(e); // здесь пробросить вверх, завернуть в рантайм наше искл (Е)
        }
    }

    private static void toTrowOrNotToTrow(boolean exception) throws Exception {
        System.out.println("JavaProMain.toTrowOrNotToTrow");
        if (exception) {
            throw new Exception();
        }
        System.out.println("toTrowOrNotToTrow end.");
    }

    private static void multiExceptionCatch() {
        try {
            System.out.printf("Hello, %f", 1);
        } catch (IllegalFormatConversionException e) { // поймается, и сработает катч один раз
            System.out.println("caught (поймал) IllegalFormatConversionException!");
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) { // не поймается
            System.out.println("caught (поймал) IllegalArgumentException!");
        }
    }

    private static void throwInCatch() throws InterruptedException {
        try {
            System.out.printf("Hello, %f", 1);
        } catch (IllegalFormatConversionException e) {
            System.out.println("caught (поймал) IllegalFormatConversionException!");
            Thread.sleep(10000); // подчеркивает, проверяемое искл? ожидание 10 сек
            throw new RuntimeException();
        } finally {
            System.out.println(" - throwInCatch method end");
        }
    }

    private static void busineseException() {
        Account ivan = new Account("Ivan", 20);
        Account petr = new Account("Petr", 85);

        int ivanBalance = ivan.getBalace();
        int petrBalance = petr.getBalace();
        try {
            if (LockedAccount.LOKED_ACCOUTS[0].equals(ivan.getName()) || LockedAccount.LOKED_ACCOUTS[0].equals(petr.getName())) {
            throw new RuntimeException();
            }
            transferMoney(ivan, petr, 30);
        } catch (TransactionException e) {
            ivan.setBalace(ivanBalance); // вернуть балансы в исходное значение
            petr.setBalace(petrBalance);
        }
        System.out.println(ivan); // распечататть аккуанты
        System.out.println(petr);


    }

    private static void transferMoney(Account from, Account to, int amount1) {
        LockedAccount toLocked = new LockedAccount(to.getName(), to.getBalace());
        to.changeBalance(amount1);
        from.changeBalance(-amount1);
        LockedAccount.LOKED_ACCOUTS[0]=null;// очищаем локед
    }
}

