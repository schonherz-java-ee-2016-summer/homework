package hu.schonherz.java.training.server;

/**
 *
 */
public class WindowsServer extends Server {

    /**
     *
     */
    @Override
    public final void restart() {
        System.out.println("Windows server is restarting...");
    }

    /**
     *
     * @param id id
     * @param name name
     * @param status status
     */
    public WindowsServer(
            final String id, final String name, final String status) {
        super(id, name, status);
    }
}

