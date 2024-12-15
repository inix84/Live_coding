package com.skypro.account.v3;

public class Account { // класс Счет, содержащий имя и баланс счета
    private String name;
    private int balace;

    public Account(String name, int balace) {
        // ИНКАПСУЛЯЦИЯ ЛОГИКИ , в конструктор добавляют проверку корректности созданного объекта
        if (name == null || name.isBlank()){ // если имя не имеет ссылки ни на каой объект, или имя пустое
            throw new IllegalArgumentException("Аккакуунт без имени");
        }
        // налогично можно сделать с балансом, проверка баланса
        if (balace<0){ // если имя не имеет ссылки ни на каой объект, или имя пустое
            throw new IllegalArgumentException("Аккакуунт без денег");
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
        //  проверка баланса, на минусовой чтоб не было
        if (balace<0){ // если имя не имеет ссылки ни на каой объект, или имя пустое
            throw new IllegalArgumentException("Аккакуунт без денег");
        }
        this.balace = balace;
    }

    @Override
    public String toString() {
        return name + " имеет " + balace;
    }
}
