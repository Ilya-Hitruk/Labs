package hw27;

import hw27.Bank.Bank;
import hw27.Bank.BankQueue;
import hw27.Client.Clients;

public class Main implements Clients {
    public static void main(String[] args) {
        BankQueue bankQueue = new BankQueue();

        bankQueue.enqueue(ilya);
        bankQueue.enqueue(ihor);
        bankQueue.enqueue(tatiana);
        bankQueue.enqueue(leonid);
        bankQueue.enqueue(oksana);
        bankQueue.enqueue(vitalii);
        bankQueue.enqueue(maxim);
        bankQueue.enqueue(alice);
        bankQueue.enqueue(ekaterina);


        Bank bank = new Bank(bankQueue);
        bank.start();
    }
}
