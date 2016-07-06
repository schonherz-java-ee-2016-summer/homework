package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;

public abstract class Server {

    private int cpuUsage;
    private int memoryUsage;
    private Database.Status status;

    public int getCpuUsage() {
        return cpuUsage;
    }
  
    public int getMemoryUsage() {
        return memoryUsage;
    }

    abstract public int getID();

    abstract public void setID(int ID);

    abstract public String getName();

    abstract public void setName(String name);

    abstract public String getType();

    abstract public void setType(String type);

    public String getStatus() {
        return status.name();
    }

    public void setStatus(Database.Status status) {
        this.status = status;
    }

    public abstract void restart();
}
