package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;

public class LinuxDatabaseAndWebServer extends LinuxServer implements Database, WebContainer {

    public enum Status {RUNNING, DATABASESTOPPED, WEBCONTAINERSTOPPED}

    private Status status;

    public LinuxDatabaseAndWebServer(int ID, String name, String type, Status status) {
        super(ID, name, type);
        this.status = status;
    }

    @Override
    public void startWebContainer() {
        System.out.println("Web container is starting");
    }

    @Override
    public void stopWebContainer() {
        System.out.println("Web container is stopping");
    }

    @Override
    public void restartWebContainer() {
        if (status == Status.RUNNING) {
            stopWebContainer();
        }

        startWebContainer();
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    @Override
    public String getConnectionURL() {
        return "localhost:54321";
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof LinuxDatabaseAndWebServer)) {
            return false;
        }

        LinuxDatabaseAndWebServer linuxDaws = (LinuxDatabaseAndWebServer) obj;

        return this.getID() == linuxDaws.getID() && this.getName().equals(linuxDaws.getName())
                && this.getType().equals(linuxDaws.getType()) && this.getStatus().equals(linuxDaws.getStatus());
    }

}
