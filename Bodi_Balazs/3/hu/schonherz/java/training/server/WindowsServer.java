package hu.schonherz.java.training.server;

public class WindowsServer extends Server {

    private int ID;
    private String Name;
    private String Type;

    public WindowsServer(int ID, String name, String type) {
        this.ID = ID;
        Name = name;
        Type = type;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getType() {
        return Type;
    }

    @Override
    public void restart() {
        System.out.println("Windows server is restarting...");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ID).append(" ").append(Name).append(" ").append(Type);
        return sb.toString();
    }

}
