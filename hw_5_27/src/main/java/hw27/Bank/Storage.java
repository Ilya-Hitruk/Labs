package hw27.Bank;

public class Storage {
    private static final int STARTED_MONEY_VALUE = 1000000;
    private int moneyValue;

    public Storage() {

        this.moneyValue = STARTED_MONEY_VALUE;
    }

    public int getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(int moneyValue) {
        this.moneyValue = moneyValue;
    }
}
