package hu.schonherz.java.training.server;

public abstract class Server {
    private String name;
    private int id;
    private int cpuUsage;
    private int memoryUsage;

    public int getCpuUsage() {
        return cpuUsage;
    }

    public int getMemoryUsage() {
        return memoryUsage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Server{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public abstract void restart();


}
