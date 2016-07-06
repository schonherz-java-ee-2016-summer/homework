package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import java.util.List;

public class LinuxWebServer extends LinuxServer implements WebContainer {

    private Status status;

    public LinuxWebServer(String id, String name, String status) {
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
    public List<SystemAdministrator> getAdmins() {
        return super.getAdmins();
    }
    

    @Override
    public String getStatus() {
        return status.name();
    }
    
    @Override
    public boolean isRunning() {
        return super.isRunning();
    }

    @Override
    public void startWebContainer() {
        System.out.println("Web container is starting...");
    }

    @Override
    public void stopWebContainer() {
        System.out.println("Web container is stopping...");
    }

    @Override
    public void restartWebContainer() {
        if (status == Status.RUNNING) {
            stopWebContainer();
        }

        startWebContainer();
    }
}
