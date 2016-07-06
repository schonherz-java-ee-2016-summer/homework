package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import java.util.List;

public class WindowsDatabaseServer extends WindowsServer implements Database {

    private Status status;

    public WindowsDatabaseServer(String id, String name, String status) {
        super(id, name, status);
    }

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
    public boolean isRunning() {
        return super.isRunning();
    }

    @Override
    public List<SystemAdministrator> getAdmins() {
        return super.getAdmins();
    }
    @Override
    
    public String getStatus() {
        return status.toString();
    }
 
    /*
    // default method has been implemented
    @Override
    public String getConnectionURL() {
        return "localhost:12345";
    }*/

}
