package hu.schonherz.java.training.server;

public class LinuxServer extends Server {

    private int ID;
    private String name;
    private String type;

    //created
    public LinuxServer(int ID, String name, String type) {
        this.ID = ID;
        this.name = name;
        this.type = type;
    }


    @Override
    public void restart() {
        System.out.println("Linux server is restarting...");
    }

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

}
