package hw27;

public record Client(String name, int id, int timeForService) implements Runnable {

    @Override
    public void run() {
        System.out.printf("Client %s approach to the window\n\n", name());
        try {
            Thread.sleep(timeForService);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Client %s left from the window\n\n", name());
    }
}
