package hu.schonherz.java.training.server;

public class WindowsServer extends Server {

    private int id;
    private String name;
    private String type;

    public WindowsServer(int id, String name, String type) {
        this.id = id;
        name = name;
        type = type;
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
        System.out.println("Windows server is restarting...");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(" ").append(name).append(" ").append(type);
        return sb.toString();
    }

}
