package hu.schonherz.java.training.server;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import java.util.List;

public class WindowsServer extends Server {

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setOperatingStatus(String status) {
        super.setOperatingStatus(status); 
    }

    @Override
    public String getOperatingStatus() {
        return super.getOperatingStatus();
    }
    
    @Override
    public boolean isRunning() {
        return super.isRunning();
    }

    @Override
    public void setAdmins(List<SystemAdministrator> admins) {
        super.setAdmins(admins);
    }
    
    @Override
    public void addAdmin(SystemAdministrator admin) {
        super.addAdmin(admin);
    }
    
    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public List<SystemAdministrator> getAdmins() {
        return super.getAdmins();
    }
    @Override
    public void restart() {
        System.out.println("Windows server is restarting...");
    }

    public WindowsServer(String id, String name, String status) {
        super(id, name, status);
    }

}
