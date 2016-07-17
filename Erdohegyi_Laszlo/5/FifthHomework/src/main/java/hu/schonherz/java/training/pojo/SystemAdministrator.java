package hu.schonherz.java.training.pojo;

import java.util.List;

import hu.schonherz.java.training.server.Server;

/**
 * Plain Old Java Object for system administrators.
 */
public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Server> servers;

    public SystemAdministrator() {
        super();
    }

    public SystemAdministrator(String name, int employeeID, List<Server> servers){
        super(name, employeeID);
        this.servers = servers;
    }

    public SystemAdministrator(String name, int employeeID){
        super(name, employeeID);
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

        SystemAdministrator sysAdmin = (SystemAdministrator) obj;

        return this.getName().equals(sysAdmin.getName()) && this.getEmployeeID() == sysAdmin.getEmployeeID();
    }

}
