package hw27;

public class Main implements Clients {
    public static void main(String[] args) throws InterruptedException {

        BankQueue firstBankQueue = new BankQueue();
        firstBankQueue.enqueue(ilya);
        firstBankQueue.enqueue(ihor);
        firstBankQueue.enqueue(tatiana);

        BankWindow firstBankWindow = new BankWindow(1, firstBankQueue);
        Thread firstWindow = new Thread(firstBankWindow);
        firstWindow.start();


        BankQueue secondBankQueue = new BankQueue();
        secondBankQueue.enqueue(leonid);
        secondBankQueue.enqueue(oksana);
        secondBankQueue.enqueue(vitalii);

        BankWindow secondBankWindow = new BankWindow(2, secondBankQueue);
        Thread secondWindow = new Thread(secondBankWindow);
        secondWindow.start();


        BankQueue thirdBankQueue = new BankQueue();
        thirdBankQueue.enqueue(maxim);
        thirdBankQueue.enqueue(alice);
        thirdBankQueue.enqueue(ekaterina);

        BankWindow thirdBankWindow = new BankWindow(3, thirdBankQueue);
        Thread thirdWindow = new Thread(thirdBankWindow);
        thirdWindow.start();
    }
}
