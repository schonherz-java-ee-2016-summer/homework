package hu.schonherz.java.training.server;

/**
 * A class for linux servers.
 */
public class LinuxServer extends Server {

    private int id;
    private String name;
    private String type;

    public LinuxServer(int id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void restart() {
        System.out.println("Linux server is restarting...");
    }

}
