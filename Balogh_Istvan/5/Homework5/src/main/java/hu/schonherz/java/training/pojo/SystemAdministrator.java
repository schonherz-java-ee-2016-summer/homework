package hu.schonherz.java.training.pojo;

import hu.schonherz.java.training.server.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a system administrator.
 */
public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Server> servers;
    private List<Integer> serverIDs;

    public SystemAdministrator() {
        super();
    }

    public SystemAdministrator(String name, int employeeID) {
        super(name, employeeID);
        servers = new ArrayList<Server>();
        serverIDs = new ArrayList<Integer>();
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", servers=" + servers + "}";
    }

    public List<Integer> getServerIDs() {
        return serverIDs;
    }

    public void setServerIDs(List<Integer> serverIDs) {
        this.serverIDs = serverIDs;
    }
}
