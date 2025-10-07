package ua.opnu.java.inheritance.account;

public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int initialBalance = getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMax();
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateMinMax();
    }

    private void updateMinMax() {
        int currentBalance = getBalance();
        if (currentBalance < minBalance) minBalance = currentBalance;
        if (currentBalance > maxBalance) maxBalance = currentBalance;
    }

    public int getMin() {
        return minBalance;
    }

    public int getMax() {
        return maxBalance;
    }
}
