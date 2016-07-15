package hu.schonherz.java.training.server;

/**
 * Created by Home on 2016. 07. 12..
 */

public abstract class Server {

    private int cpuUsage;
    private int memoryUsage;
    private int id;
    private String name;

    public int getCpuUsage() {
        return cpuUsage;
    }

    public int getMemoryUsage() {
        return memoryUsage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public abstract void restart();
}