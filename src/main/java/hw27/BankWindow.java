package hw27;

import lombok.SneakyThrows;

public class BankWindow implements Bank {

    private final int numberOfWindow;
    private final BankQueue bankQueue;


    public BankWindow(int numberOfWindow, BankQueue bankQueue) {
        this.numberOfWindow = numberOfWindow;
        this.bankQueue = bankQueue;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (!bankQueue.isQueueEmpty()) {
            Client currentClient = serveNextClient();
            Thread clientProcessing = new Thread(currentClient);
            clientProcessing.start();
            clientProcessing.join();
            System.out.printf("Client - %s with id - %d has been serviced in the window - %d!\n\n",
                                currentClient.name(), currentClient.id(), numberOfWindow);
        }
    }

    @Override
    public Client serveNextClient() {
        return bankQueue.dequeue();
    }
}
