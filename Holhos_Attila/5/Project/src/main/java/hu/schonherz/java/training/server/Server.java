package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;

/**
 * JavaDoc
 */

public class Server {

    private int ID;
    private String name;
    private String type;
    private String status;

    public Server(int ID, String name, String type, String status) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Server{" +
                "ID= " + ID +
                ", name= '" + name + '\'' +
                ", type= '" + type + '\'' +
                ", status= " + status +
                '}';
    }

}
