package hu.schonherz.java.training.server;

/**
 * Created by Attila on 2016.07.07..
 */
public class RunningServer extends Server{
    private int ID;
    private String name;
    private String type;
    private boolean runningStatus;

    public RunningServer(int ID, String name, String type, boolean runningStatus) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.runningStatus = runningStatus;
    }

    @Override
    public String toString() {
        return "RunningServer{" +
                "ID= " + ID +
                ", name= '" + name + '\'' +
                ", type= '" + type + '\'' +
                ", runningStatus= " + runningStatus +
                '}';
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

    public boolean getRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(boolean runningStatus) {
        this.runningStatus = runningStatus;
    }

    @Override
    public void restart() {
        System.out.println("Windows server is restarting...");
    }
}
