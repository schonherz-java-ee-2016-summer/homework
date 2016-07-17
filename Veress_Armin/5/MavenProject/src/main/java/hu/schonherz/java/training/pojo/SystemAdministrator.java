package hu.schonherz.java.training.pojo;

import hu.schonherz.java.training.server.Server;
import java.util.List;

/**
 *
 */
public class SystemAdministrator extends Employee {

    /**
     *
     */
    private static final long serialVersionUID = 2244059719140625986L;
    /**
     *
     */
    private List < Server > servers;

    /**
     *
     */
    public SystemAdministrator() {
        super();
    }

    /**
     *
     * @param name name
     * @param employeeID employeeID
     * @param servers servers
     */
    public SystemAdministrator(
            final String name, final int employeeID,
            final List < Server > servers) {
        super(name, employeeID);
        this.servers = servers;
    }

    /**
     *
     * @return lol
     */
    public final List < Server > getServers() {
        return servers;
    }

    /**
     *
     * @param servers servers
     */
    public final void setServers(final List < Server > servers) {
        this.servers = servers;
    }

    /**
     *
     * @param obj obj
     * @return lol
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean b1 = super.equals(obj);
        boolean b2 = this.getServers().equals((
                (SystemAdministrator) obj).getServers());
        List < Server > srv1 = this.getServers();
        List < Server > srv2 = ((SystemAdministrator) obj).getServers();
        return super.equals(obj)
                && this.getServers().equals(
                ((SystemAdministrator) obj).getServers());
    }

    /**
     *
     * @return lol
     */
    @Override
    public final int hashCode() {
        return servers.hashCode();
    }
}
