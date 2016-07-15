package hu.schonherz.java.training.server;

/**
 * Represents a specific type of server.
 */
public class WindowsServer extends Server {

    @Override
    public void restart() {
        System.out.println("Windows server is restarting...");
    }

}
