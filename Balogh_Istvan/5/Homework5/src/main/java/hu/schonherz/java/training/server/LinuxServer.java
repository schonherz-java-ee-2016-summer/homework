package hu.schonherz.java.training.server;

/**
 * This class represents a Linux Server.
 */
public class LinuxServer extends Server {

    @Override
    public void restart() {
        System.out.println("Linux server is restarting...");
    }

}
