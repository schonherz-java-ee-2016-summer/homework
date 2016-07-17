package hu.schonherz.java.training.server;

/**
 * This class extends the Server class.
 */

public class LinuxServer extends Server{
    private int id;
    private String name;
    private String type;

    public LinuxServer(int id, String name, String type){
        type = type;
        name = name;
        this.id = id;
    }

    /**
     * @return
     */
    @Override
    public int getID(){
        return id;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public void restart(){
        System.out.println("Linux server is restarting...");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(" ").append(name).append(" ").append(type);
        return sb.toString();
    }
}
