package hu.schonherz.java.training.server;

public abstract class Server {

    private int cpuUsage;
    private int memoryUsage;
    private int id;
    private String name;
    private String type;
    private String status;


    public int getCpuUsage() {
        return cpuUsage;
    }

    public int getMemoryUsage() {
        return memoryUsage;
    }

    public abstract void restart();


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
}
