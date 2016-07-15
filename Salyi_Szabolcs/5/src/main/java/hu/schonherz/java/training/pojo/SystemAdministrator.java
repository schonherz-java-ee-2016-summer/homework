package hu.schonherz.java.training.pojo;

import hu.schonherz.java.training.server.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 2016. 07. 12..
 */
public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Server> servers;
    private List<Integer> serverIDs;

    public SystemAdministrator() {
        super();
    }

    //created
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

    public List<Integer> getServerIDs() {
        return serverIDs;
    }

    public void setServerIDs(List<Integer> serverIDs) {
        this.serverIDs = serverIDs;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.name).append(this.employeeID).append(" ");
        for(Integer id : serverIDs){
            result.append(id).append(" ");
        }
        return result.toString();
    }
}