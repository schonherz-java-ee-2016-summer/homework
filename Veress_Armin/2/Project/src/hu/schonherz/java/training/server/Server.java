package hu.schonherz.java.training.server;

import java.util.List;
import hu.schonherz.java.training.pojo.SystemAdministrator;

public abstract class Server {

    private int cpuUsage;
    private int memoryUsage;
    private String serverName;
    private List<SystemAdministrator> sysAdmins;

    public String getServerName() {
        return serverName;
    }

    public List<SystemAdministrator> getSysAdmins() {
        return sysAdmins;
    }

    public void setCpuUsage(int cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public void setMemoryUsage(int memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setSysAdmins(List<SystemAdministrator> sysAdmins) {
        this.sysAdmins = sysAdmins;
    }

    public int getCpuUsage() {
        return cpuUsage;
    }
  
    public int getMemoryUsage() {
        return memoryUsage;
    }
  
    public abstract void restart();
}
