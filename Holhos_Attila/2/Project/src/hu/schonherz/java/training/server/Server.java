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

    public abstract void restart();
}
