package hu.schonherz.java.training.pojo;

import java.util.List;

public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Integer> servers;

    public SystemAdministrator() {
        super();
    }

    public SystemAdministrator(String name, int employeeID, List<Integer> servers){
        this.name=name;
        this.employeeID=employeeID;
        this.servers=servers;
    }

    public List<Integer> getServers() {
        return servers;
    }

    public void setServers(List<Integer> servers) {
        this.servers = servers;
    }

}
