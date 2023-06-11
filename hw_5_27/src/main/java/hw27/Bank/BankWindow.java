package hw27.Bank;

import hw27.Client.Client;
import hw27.Client.GoalOfVisit;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankWindow extends Thread {
    private final Logger logger = LoggerFactory.getLogger(BankWindow.class);
    private final Lock readLock;
    private final Lock writeLock;


    private final int numberOfTheWindow;
    private final BankQueue bankQueue;
    private int moneyOfTheWindow;


    public BankWindow(int numberOfTheWindow, BankQueue bankQueue, int moneyOfTheWindow) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();

        this.numberOfTheWindow = numberOfTheWindow;
        this.bankQueue = bankQueue;
        this.moneyOfTheWindow = moneyOfTheWindow;
        this.start();
    }

    @SneakyThrows
    @Override
    public void run() {
        while (bankQueue.isQueueContainsClients()) {
            Client currentClient = serveNextClient();
            logger.info(currentClient.name() + " window - " + numberOfTheWindow);
            Thread clientThread = new Thread(currentClient);
            clientThread.start();
            clientThread.join();
            service(currentClient.goal(), currentClient.money());

            logger.info(serviceReport(currentClient));
        }
    }

    private void service(GoalOfVisit goal, int sum) {
        if (goal == GoalOfVisit.WITHDRAW) {
            withdraw(sum);
        }
        if (goal == GoalOfVisit.DEPOSIT) {
            deposit(sum);
        }
    }

    private void withdraw(int sumOfWithdraw) {
        setMoneyOfTheWindow(getMoneyOfTheWindow() - sumOfWithdraw);
    }

    private void deposit(int sumOFDeposit) {
        setMoneyOfTheWindow(moneyOfTheWindow + sumOFDeposit);
    }
    private Client serveNextClient() {
        return bankQueue.dequeue();
    }

    public int getMoneyOfTheWindow() {
        readLock.lock();
        int money = moneyOfTheWindow;
        readLock.unlock();
        return money;
    }

    public void setMoneyOfTheWindow(int moneyOfTheWindow) {
        writeLock.lock();
        this.moneyOfTheWindow = moneyOfTheWindow;
        writeLock.unlock();
    }

    private String serviceReport(Client client) {
        return switch (client.goal()) {
            case WITHDRAW -> String.format(Reports.WITHDRAW.getReport(), client.name(), client.money(), numberOfTheWindow, getMoneyOfTheWindow());
            case DEPOSIT -> String.format(Reports.DEPOSIT.getReport(), client.name(), client.money(), numberOfTheWindow, getMoneyOfTheWindow());
        };
    }
}
