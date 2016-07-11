/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonerz.training.pojo;

/**
 *
 * @author Roli
 */
import java.util.List;

public class SystemAdministrator extends Employee {

    private static final long serialVersionUID = 2244059719140625986L;
    private List<Integer> servers;

    public SystemAdministrator() {
        super();
    }

    public SystemAdministrator(String name, int id, List<Integer> servers) {
        super(name, id);
        this.servers = servers;
    }

    public List<Integer> getServers() {
        return servers;
    }

    @Override
    public String getName() {
        return name;
    }

}
