package hu.schonherz.java.training.server;

/**
 * Represents a specific type of server.
 */
public class LinuxServer extends Server {

    @Override
    public void restart() {
        System.out.println("Linux server is restarting...");
    }

}
