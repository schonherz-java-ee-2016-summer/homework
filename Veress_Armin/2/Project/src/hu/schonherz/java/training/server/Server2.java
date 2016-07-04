package hu.schonherz.java.training.server;
import hu.schonherz.java.training.pojo.SystemAdministrator;

import java.util.List;
/**
 * Created by Lenovo on 2016.07.04..
 */
public class Server2 {
    private int ID;
    private String ServerName;
    private String ServerType;
    private List<SystemAdministrator> Admin;
    private String statusz;

    public Server2() {
    }

    public Server2(int ID, String serverName, String serverType, String statusz) {
        this.ID = ID;
        ServerName = serverName;
        ServerType = serverType;
        this.statusz = statusz;
    }

    public int getID() {
        return ID;
    }

    public String getServerName() {
        return ServerName;
    }

    public String getServerType() {
        return ServerType;
    }

    public List<SystemAdministrator> getAdmin() {
        return Admin;
    }

    public String getStatusz() {
        return statusz;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setServerName(String serverName) {
        ServerName = serverName;
    }

    public void setServerType(String serverType) {
        ServerType = serverType;
    }

    public void setAdmin(List<SystemAdministrator> admin) {
        Admin = admin;
    }

    public void setStatusz(String statusz) {
        this.statusz = statusz;
    }
}
