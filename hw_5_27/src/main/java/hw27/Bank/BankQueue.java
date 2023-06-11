package hw27.Bank;

import hw27.Client.Client;

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

    public boolean isQueueContainsClients() {
        return !clientQueue.isEmpty();
    }
    public int getSize() {
        return clientQueue.size();
    }

    @Override
    public String toString() {
        return clientQueue.toString();
    }

}
