package hu.schonherz.java.training.pojo;

import hu.schonherz.java.training.server.Server;

import java.util.List;
/**
 *
 */
public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Server> servers;

    public SystemAdministrator() {
        super();
    }
    // create
    public SystemAdministrator(String name, int employeeID, List<Server> servers){
        super(name, employeeID);
        this.servers = servers;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof SystemAdministrator)) {
            return false;
        }
        SystemAdministrator systemadmin = (SystemAdministrator) obj;

        return this.getName().equals(systemadmin.getName()) && this.getEmployeeID() == systemadmin.getEmployeeID();
    }
}
