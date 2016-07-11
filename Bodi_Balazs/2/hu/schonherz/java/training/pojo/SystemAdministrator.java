package hu.schonherz.java.training.pojo;

import java.util.LinkedList;
import java.util.List;
import java.util.jar.Attributes;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.server.Server;
import jdk.nashorn.internal.objects.NativeArray;

public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Integer> servers;

    public SystemAdministrator() {
        super();
    }

    public SystemAdministrator(String name, int employeeID, List<Integer> servers) {
        super(name, employeeID);
        this.servers = servers;
    }

    public List<Integer> getServers() {
        return servers;
    }

    public void setServers(List<Integer> servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(servers);
        return sb.toString();
    }

}