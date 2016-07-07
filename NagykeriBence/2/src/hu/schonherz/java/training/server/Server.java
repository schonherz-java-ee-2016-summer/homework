package hu.schonherz.java.training.server;

public abstract class Server {
    private String name;
    private int cpuUsage;
    private int memoryUsage;
  
    public int getCpuUsage() {
        return cpuUsage;
    }
  
    public int getMemoryUsage() {
        return memoryUsage;
    }

    public String getName(){
        return name;
    }
    public void setName(String _name){
         name = _name;
    }
    public abstract void restart();

    @Override
    public String toString() {
        return "Server{" +
                "name='" + name + '\'' +
                ", cpuUsage=" + cpuUsage +
                ", memoryUsage=" + memoryUsage +
                '}';
    }
}
