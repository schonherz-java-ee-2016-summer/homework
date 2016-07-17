package hu.schonherz.java.training.server;

import hu.schonherz.java.training.serverservice.WebContainer;

/**
 * A class for linux web servers.
 */
public class LinuxWebServer extends LinuxServer implements WebContainer {

    private Status status;

    public LinuxWebServer(int id, String name, String type, Status status) {
        super(id, name, type);
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    @Override
    public void startWebContainer() {
        System.out.println("Web container is starting...");
    }

    @Override
    public void stopWebContainer() {
        System.out.println("Web container is stopping...");
    }

    @Override
    public void restartWebContainer() {
        if (status == Status.RUNNING) {
            stopWebContainer();
        }

        startWebContainer();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof LinuxWebServer)) {
            return false;
        }

        LinuxWebServer linuxWs = (LinuxWebServer) obj;

        return this.getID() == linuxWs.getID() && this.getName().equals(linuxWs.getName())
                && this.getType().equals(linuxWs.getType()) && this.getStatus().equals(linuxWs.getStatus());
    }

}
