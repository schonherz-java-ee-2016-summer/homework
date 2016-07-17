package hu.schonherz.java.training.server;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Server {

    private String id;
    private String name;
    private String operatingSstatus;
    private List < SystemAdministrator > admins;
    private int cpuUsage;
    private int memoryUsage;

    public Server(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.operatingSstatus = status;
        this.admins = new ArrayList<>();
    }

    public Server(String id, String name) {
        this.id = id;
        this.name = name;
        this.operatingSstatus = "UNKNOWN";
        this.admins = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setOperatingStatus(String status) {
        this.operatingSstatus = status;
    }

    public String getOperatingStatus() {
        return operatingSstatus;
    }
    
    public boolean isRunning() {
        return (boolean)("RUNNING".equals(operatingSstatus));
    }
    
    public void setAdmins(List < SystemAdministrator > admins) {
        this.admins = admins;
    }
    
    public void addAdmin(SystemAdministrator admin) {
        boolean exist = false;
        for (SystemAdministrator ad : admins)
        {
            if(ad.equals(admin))
            {
                exist = true;
            }
        }
        if (!exist)
            this.admins.add(admin);
    }
    
  
    public int getCpuUsage() {
        return cpuUsage;
    }
  
    public int getMemoryUsage() {
        return memoryUsage;
    }
    public List < SystemAdministrator > getAdmins() {
        return admins;
    }
  
    public abstract void restart();

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Server)){
            return false;
        }
        else
            return (this.getId().equals(((Server) obj).getId())
                    && this.getName().equals(((Server) obj).getName())
                    && this.getOperatingStatus().equals(
                    ((Server) obj).getOperatingStatus()));
    }
}
