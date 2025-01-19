package com.skypro.account.v4;

public class Account { // класс Счет, содержащий имя и баланс счета
    //protected String name; // протектед для наследников
    String name;
    int balace;

    public Account(String name, int balace) {
        // ИНКАПСУЛЯЦИЯ ЛОГИКИ , в конструктор добавляют проверку корректности созданного объекта
        if (name == null || name.isBlank()) { // если имя не имеет ссылки ни на каой объект, или имя пустое
            throw new IllegalArgumentException("Аккакуунт без имени");
        }
        // аналогично можно сделать с балансом, проверка баланса
        if (balace < 0) { // если имя не имеет ссылки ни на каой объект, или имя пустое
            throw new IllegalArgumentException("Аккакуунт без денег");
        }
        this.name = name;
        this.balace = balace;
    }

    //public String getName() {
    //    return name;
    //}

    void changeBalance(int balaceChange) {
        if (balace + balaceChange < 0) {
            throw new IllegalArgumentException("Аккаунт без денег");
        }
        balace += balaceChange;
    }

    @Override
    public String toString() {
        return name + " имеет " + balace;
    }
}
