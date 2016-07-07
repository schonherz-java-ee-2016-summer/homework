package hu.schonherz.java.training.server;

public class WindowsServer extends Server {
    int id;
    String name;
    String type;

    public WindowsServer(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public int getId() {
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

}
