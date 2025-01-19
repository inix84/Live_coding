package com.skypro.account.v4;

public class TransferUtil {
    public static void transferMoney(Account from, Account to, int transferMoney) {
        //System.out.println(from.name + " перечисляет " + to.name + " " + transferMoney);
        System.out.println(new Transfer(from,to,transferMoney));

        from.changeBalance(-transferMoney);
        to.changeBalance(transferMoney);
    }
    private static class Transfer { // вспомогательный класс, для групппировки данных
        Account from;
        Account to;
        int transferMoney;

        public Transfer(Account from, Account to, int transferMoney) {
            this.from = from;
            this.to = to;
            this.transferMoney = transferMoney;
        }

        @Override
        public String toString() {
            return "Transfer{" +
                    "from=" + from +
                    ", to=" + to +
                    ", transferMoney=" + transferMoney +
                    '}';
        }
    }
}
