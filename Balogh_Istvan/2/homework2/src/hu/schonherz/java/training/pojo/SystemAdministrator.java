package hu.schonherz.java.training.pojo;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.server.RunningServer;
import hu.schonherz.java.training.server.Server;

public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<RunningServer> servers;
    private List<Integer> serverIDs;

    public SystemAdministrator() {
        super();
    }

    public SystemAdministrator(String name, int employeeID) {
        super(name, employeeID);
        servers = new ArrayList<RunningServer>();
        serverIDs = new ArrayList<Integer>();
    }

    public List<RunningServer> getServers() {
        return servers;
    }

    public void setServers(List<RunningServer> servers) {
        this.servers = servers;
    }

    public RunningServer getServerById(Integer id, List<RunningServer> serverList) {
        for (RunningServer server : serverList) {
            if (server.getId() == id)
                return server;
        }
        return null;
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
