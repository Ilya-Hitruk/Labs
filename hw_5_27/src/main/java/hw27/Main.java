package hw27;

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

        BankWindow firstBankWindow = new BankWindow(1, bankQueue);
        firstBankWindow.start();

        BankWindow secondBankWindow = new BankWindow(2, bankQueue);
        secondBankWindow.start();

        BankWindow thirdBankWindow = new BankWindow(3, bankQueue);
        thirdBankWindow.start();
    }
}
