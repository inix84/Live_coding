package com.skypro;
import com.skypro.account.v2.Account;
import com.skypro.account.v4.TransferUtil;

public class JavaProMain {
    public static void main(String[] args) {
        System.out.println("Skypro Un 1 - Java Professional start!");

        // 2вызовем этот метод вверху написав имя этого метода

        transferMoneyV1();
        transferMoneyV2();
        transferMoneyV3();
        transferMoneyV4();
    }
// перевести деньги со счета на счет

    private static void transferMoneyV1() {
        System.out.println("JavaProMain.TransferMoneyV1");
// есть человек Иван с его счета переводим ПЕтру, у того и другого есть баланс
        String fromName = "Ivan";
        int fromBalance = 100;
        String toName = "Petr";
        int toBalance = 60;
        System.out.println(fromName + " имеет " + fromBalance);
        System.out.println(toName + " имеет " + toBalance);
        // 40 метододв валидации и авторизации
        // хотим перевести сумму
        int transferMoney = 20;
        System.out.println(fromName + " перечисляет " + toName + " " + transferMoney);
        // вычитаем эти деньги из баланса Ивана
        fromBalance -= transferMoney;
        toBalance += transferMoney;
        System.out.println(fromName + " имеет " + fromBalance);
        System.out.println(toName + " имеет " + toBalance);

        // 1вызовем этот метод вверху написав имя этого метода2
    }

    //после создания класса, создаем и потом вызовем метод работающий с класом
    private static void transferMoneyV2() {
        System.out.println("JavaProMain.transferMoneyV2");

        // создадим пару аккуантов

        Account ivan = new Account();
        ivan.name = "Ivan";
        ivan.balace = 100;
        Account petr = new Account();
        petr.name = "Petr";
        petr.balace = 60;
        System.out.println(ivan.name + " имеет " + ivan.balace);
        System.out.println(petr.name + " имеет " + petr.balace);
        int transferMoney = 20;
        System.out.println(ivan.name + " перечисляет " + petr.name + " " + transferMoney);
        ivan.balace -= transferMoney;
        ;
        petr.balace += transferMoney;
        System.out.println(ivan.name + " имеет " + ivan.balace);
        System.out.println(petr.name + " имеет " + petr.balace);
    }

    private static void transferMoneyV3() {
        System.out.println("JavaProMain.transferMoneyV3");
        // создадим пару аккуантов
        com.skypro.account.v3.Account ivan = new com.skypro.account.v3.Account("Ivan", 100);
        com.skypro.account.v3.Account petr = new com.skypro.account.v3.Account("Petr", 60);

        System.out.println(ivan.getName() + " имеет " + ivan.getBalace());
        System.out.println(petr);
        int transferMoney = 20;
        System.out.println(ivan.getName() + " перечисляет " + petr.getName() + " " + transferMoney);
        ivan.setBalace(ivan.getBalace()- transferMoney);
        petr.setBalace(petr.getBalace()+ transferMoney);
        System.out.println(ivan);
        System.out.println(petr);
    }

    private static void transferMoneyV4() {
        System.out.println("JavaProMain.transferMoneyV4");
        // создадим пару аккуантов
        com.skypro.account.v4.Account ivan = new com.skypro.account.v4.Account("Ivan", 100);
        com.skypro.account.v4.Account petr = new com.skypro.account.v4.Account("Petr", 60);

        System.out.println(ivan);
        System.out.println(petr);
        int transferMoney = 20;
        //ivan.changeBalance(transferMoney); // этот метод стал не публичный, а дефолтный (внутри пакетный)
        TransferUtil.transferMoney(ivan,petr,transferMoney); // контр и левая кнопка мыши, перекинет в этот метод

        System.out.println(ivan);
        System.out.println(petr);
    }
}
