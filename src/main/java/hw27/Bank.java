package hw27;

public interface Bank extends Runnable {
    Client serveNextClient();
}
