package hu.schonherz.java.training.server;

public class RunningServer extends Server {

    private int id;
    private String name;
    private String type;
    private boolean running;

    public RunningServer() {
        super();
    }

    public RunningServer(int id, String name, String type, boolean running) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.running = running;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RunningServer that = (RunningServer) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null && (type != null ? type.equals(that.type) : that.type == null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RunningServer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void restart() {
        System.out.println("Server is restarting...");
    }

}
