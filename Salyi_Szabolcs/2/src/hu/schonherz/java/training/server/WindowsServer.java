package hu.schonherz.java.training.server;

public class WindowsServer extends Server {

    private int ID;
    private String name;
    private String type;

    //created
    public WindowsServer(int ID, String name, String type) {
        this.ID = ID;
        this.name = name;
        this.type = type;
    }

    @Override
    public void restart() {
        System.out.println("Windows server is restarting...");
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
