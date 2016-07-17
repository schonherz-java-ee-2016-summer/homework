package hu.schonherz.java.training.server;

public class LinuxServer extends Server {
    private int ID;
    private String Name;
    private String Type;

    public LinuxServer(int ID, String name,String type ) {
        Type = type;
        Name = name;
        this.ID = ID;
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
        System.out.println("Linux server is restarting...");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ID).append(" ").append(Name).append(" ").append(Type);
        return sb.toString();
    }
}
