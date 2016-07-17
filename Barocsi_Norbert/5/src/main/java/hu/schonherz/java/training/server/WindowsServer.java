package hu.schonherz.java.training.server;
/**
 *
 */
public class WindowsServer extends Server {

    private int identity;
    private String name;
    private String type;

    public WindowsServer(int identity, String name, String type){
        this.identity = identity;
        this.name = name;
        this.type = type;
    }

    @Override
    public int getIdentity() {
        return identity;
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
