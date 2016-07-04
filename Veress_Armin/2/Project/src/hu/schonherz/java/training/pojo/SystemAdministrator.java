package hu.schonherz.java.training.pojo;

import java.util.List;

import hu.schonherz.java.training.server.Server2;

public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Server2> servers;

    public SystemAdministrator() {
        super();
    }

    public SystemAdministrator(String name, int employeeID, List<Server2> servers) {
        super(name, employeeID);
        this.servers = servers;
    }

    public List<Server2> getServers() {
        return servers;
    }

    public void setServers(List<Server2> servers) {
        this.servers = servers;
    }

}
