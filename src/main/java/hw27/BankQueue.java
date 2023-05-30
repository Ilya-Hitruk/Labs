package hw27;

import java.util.LinkedList;
import java.util.Queue;

public class BankQueue {

    private final Queue<Client> clientQueue;


    public BankQueue() {
        this.clientQueue = new LinkedList<>();
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
