package hw27.Client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record Client(String name, int id, int timeForService, GoalOfVisit goal, int money) implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    @Override
    public void run() {
        try {
            Thread.sleep(timeForService);
        } catch (InterruptedException e) {
            logger.error("Something went wrong");
            Thread.currentThread().interrupt();
        }
    }
}
