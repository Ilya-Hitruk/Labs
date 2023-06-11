package hw27.Bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class Bank extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Bank.class);
    private static final int MONEY_LIMIT_WINDOW = 200000;
    private final Storage storage;
    protected final BankQueue bankQueue;
    private final LinkedList<BankWindow> windows;
    private int countOfWindows;

    public Bank(BankQueue bankQueue) {
        this.bankQueue = bankQueue;
        this.storage = new Storage();
        this.windows = new LinkedList<>();
        this.countOfWindows = 0;
    }

    @Override
    public void run() {
        windows.add(openWindow());
        windows.add(openWindow());
        windows.add(openWindow());
        try {
            for (BankWindow bankWindow: windows) {
                bankWindow.join();
            }
        } catch (InterruptedException e) {
            logger.error("Something went wrong ");
            Thread.currentThread().interrupt();
        }


        shareExtraMoneyToStorage();

    }

    private BankWindow openWindow() {
        countOfWindows++;
        return new BankWindow(countOfWindows, bankQueue, getMoneyForWindow());
    }

    private void shareExtraMoneyToStorage() {
        for (BankWindow bankWindow: windows) {
            if (bankWindow.getMoneyOfTheWindow() > MONEY_LIMIT_WINDOW) {
                storage.setMoneyValue(bankWindow.getMoneyOfTheWindow() - MONEY_LIMIT_WINDOW);
                bankWindow.setMoneyOfTheWindow(MONEY_LIMIT_WINDOW);
            }
        }
    }
     private int getMoneyForWindow() {
        storage.setMoneyValue(storage.getMoneyValue() - MONEY_LIMIT_WINDOW);
        return MONEY_LIMIT_WINDOW;
    }
}
