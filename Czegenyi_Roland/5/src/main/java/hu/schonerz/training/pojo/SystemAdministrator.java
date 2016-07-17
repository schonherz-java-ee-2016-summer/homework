package hu.schonerz.training.pojo;

import java.util.List;
import net.sourceforge.cobertura.CoverageIgnore;

/**
 * Class for representing a system administrator.
 */
@CoverageIgnore
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
