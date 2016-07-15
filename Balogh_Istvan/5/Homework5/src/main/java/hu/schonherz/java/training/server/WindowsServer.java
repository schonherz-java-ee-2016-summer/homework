package hu.schonherz.java.training.server;

/**
 * This class represents a Windows Server.
 */
public class WindowsServer extends Server {

    @Override
    public void restart() {
        System.out.println("Windows server is restarting...");
    }

}
