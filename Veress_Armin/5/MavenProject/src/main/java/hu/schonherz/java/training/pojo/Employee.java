package hu.schonherz.java.training.pojo;

import java.io.Serializable;

/**
 *
 */
public class Employee implements Serializable {

    /**
     *
     */
    static final int SZAM = 31;
    /**
     *
     */
    private static final long serialVersionUID = 7950521176579703924L;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private int employeeID;

    /**
     *
     */
    public Employee() {
        super();
    }

    /**
     *
     * @param name name
     * @param employeeID employeeID
     */
    public Employee(final String name, final int employeeID) {
        super();
        this.setName(name);
        this.setEmployeeID(employeeID);
    }

    /**
     *
     * @return lol
     */
    public final String getName() {
        return name;
    }

    /**
     *
     * @param name name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return lol
     */
    public final int getEmployeeID() {
        return employeeID;
    }

    /**
     *
     * @param employeeID employeeID
     */
    public final void setEmployeeID(final int employeeID) {
        this.employeeID = employeeID;
    }
}
