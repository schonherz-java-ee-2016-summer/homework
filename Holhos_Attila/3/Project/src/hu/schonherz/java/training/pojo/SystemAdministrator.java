package hu.schonherz.java.training.pojo;

import java.util.List;

import hu.schonherz.java.training.server.RunningServer;
import hu.schonherz.java.training.server.Server;

public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<RunningServer> servers;

    public SystemAdministrator() {
        super();
    }

    public SystemAdministrator(String name, int employeeID, List<RunningServer> servers){
        this.name=name;
        this.employeeID=employeeID;
        this.servers=servers;
    }

    public List<RunningServer> getServers() {
        return servers;
    }

    public void setServers(List<RunningServer> servers) {
        this.servers = servers;
    }

}
