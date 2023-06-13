package Multithreading.Synchronizers.CountDownLatchExample;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class Market {

    private final static Logger logger = LoggerFactory.getLogger(Market.class);
    private final static CountDownLatch countDownLatch = new CountDownLatch(3);


    private static void marketStuffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Stuff of the market is on the place");
        countDownLatch.countDown();
        logger.info(String.valueOf(countDownLatch.getCount()));
    }

    private static void prepareMarketForShopping() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("Stuff have prepared the market");
        countDownLatch.countDown();
        logger.info(String.valueOf(countDownLatch.getCount()));
    }

    private static void openTheMarket() throws InterruptedException {
        Thread.sleep(4000);
        logger.info("Market is opened");
        countDownLatch.countDown();
        logger.info(String.valueOf(countDownLatch.getCount()));
    }

    @SneakyThrows
    public static void main(String[] args) {
        new Customer("Ilya", countDownLatch);
        new Customer("Tatiana", countDownLatch);
        new Customer("Vitaliy", countDownLatch);
        new Customer("Ekaterina", countDownLatch);
        new Customer("Inna", countDownLatch);

        marketStuffIsOnPlace();
        prepareMarketForShopping();
        openTheMarket();

    }
}

class Customer extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(Customer.class);
    private final String name;
    private final CountDownLatch countDownLatch;


    public Customer(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }
    @Override
    public void run() {
        try {
            countDownLatch.await();
            logger.info(name + " is shopping");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
