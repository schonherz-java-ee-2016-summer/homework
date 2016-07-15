package hu.schonherz.java.training.server;

/**
 * Created by Home on 2016. 07. 12..
 */
public class LinuxServer extends Server {

    @Override
    public void restart() {
        System.out.println("Linux server is restarting...");
    }

}