package hu.schonherz.java.training.server;

/**
 *
 */
public class LinuxServer extends Server {

    /**
     *
     * @param id id
     * @param name name
     * @param status status
     */
    public LinuxServer(
            final String id, final String name, final String status) {
        super(id, name, status);
    }

    /**
     *
     */
    @Override
    public final void restart() {
        System.out.println("Linux server is restarting...");
    }
}
