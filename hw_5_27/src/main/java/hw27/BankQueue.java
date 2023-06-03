package hw27;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BankQueue {


    private final BlockingQueue<Client> clientQueue;


    public BankQueue() {
        this.clientQueue = new LinkedBlockingQueue<>();
    }

    public void enqueue(Client client) {
        clientQueue.add(client);
    }

    public Client dequeue() {
        return clientQueue.poll();
    }

    public boolean isQueueEmpty() {
        return clientQueue.isEmpty();
    }

    @Override
    public String toString() {
        return clientQueue.toString();
    }
}
