package hu.schonherz.java.training.server;

public class WindowsServer extends Server {

    private int ID;
    private String name;
    private String type;

    public WindowsServer(int ID, String name, String type){
        this.ID = ID;
        this.name = name;
        this.type = type;
    }

    @Override
    public int getID() {
        return ID;
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
        System.out.println("Windows server is restarting...");
    }

}
