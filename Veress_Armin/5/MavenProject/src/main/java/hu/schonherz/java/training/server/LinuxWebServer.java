package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.WebContainer;

/**
 *
 */
public class LinuxWebServer extends LinuxServer implements WebContainer {

    /**
     *
     */
    private Status status;

    /**
     *
     * @param id id
     * @param name name
     * @param status status
     */
    public LinuxWebServer(
            final String id, final String name, final String status) {
        super(id, name, status);
    }

    /**
     *
     * @return lol
     */
    @Override
    public final String getStatus() {
        return status.name();
    }


    /**
     *
     */
    @Override
    public final void startWebContainer() {
        System.out.println("Web container is starting...");
    }

    /**
     *
     */
    @Override
    public final void stopWebContainer() {
        System.out.println("Web container is stopping...");
    }

    /**
     *
     */
    @Override
    public final void restartWebContainer() {
        if (status == Status.RUNNING) {
            stopWebContainer();
        }
        startWebContainer();
    }
}
