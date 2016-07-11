package hu.schonherz.java.training.pojo;

import hu.schonherz.java.training.server.Server;
import java.util.List;


public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Server> servers;

    public SystemAdministrator() {
        super();
    }
    
    public SystemAdministrator(String name, int employeeID, List<Server> servers) {
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
    public boolean equals(Object obj) {
        boolean b1 = super.equals(obj);
        boolean b2 = this.getServers().equals(((SystemAdministrator) obj).getServers());
        List<Server> srv1 = this.getServers();
        List<Server> srv2 = ((SystemAdministrator) obj).getServers();
        return super.equals(obj) && this.getServers().equals(((SystemAdministrator) obj).getServers());
    }
}
