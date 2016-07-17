package hu.schonherz.java.training.pojo;

import java.util.List;

/**
 *
 */
public class Developer extends Employee {
    /**
     *
     */
    private static final long serialVersionUID = -3936601396418860868L;

    /**
     *
     */
    private List < String > tasks;

    /**
     *
     */
    public Developer() {
        super();
    }

    /**
     *
     * @param name name
     * @param employeeID employeeID
     * @param tasks tasks
     */
    public Developer(
            final String name, final int employeeID,
            final List < String > tasks) {
        super(name, employeeID);
        this.tasks = tasks;
    }

    /**
     *
     * @return lol
     */
    public final List < String > getTasks() {
        return tasks;
    }

    /**
     *
     * @param tasks tasks
     */
    public final void setTasks(final List < String > tasks) {
        this.tasks = tasks;
    }

    /**
     *
     * @param obj obj
     * @return lol
     */
    @Override
    public final boolean equals(final Object obj) {
        return super.equals(obj);
    }

    /**
     *
     * @return lol
     */
    @Override
    public final int hashCode() {
        return tasks.hashCode();
    }
}
