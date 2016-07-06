package hu.schonherz.java.training.server;

public class WindowsServer extends Server {

    private int ID;
    private String name;
    private String type;

    public WindowsServer(int ID, String name, String type){
        this.ID=ID;
        this.name=name;
        this.type=type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void restart() {
        System.out.println("Windows server is restarting...");
    }

}
