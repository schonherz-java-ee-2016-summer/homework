package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;

public abstract class Server {

    private int cpuUsage;
    private int memoryUsage;

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

    public abstract void restart();
}
