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
     * @param nameE name
     * @param employeeIDD employeeID
     */
    public Employee(final String nameE, final int employeeIDD) {
        super();
        this.setName(nameE);
        this.setEmployeeID(employeeIDD);
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
     * @param nameL name
     */
    public final void setName(final String nameL) {
        this.name = nameL;
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
     * @param employeeIDT employeeID
     */
    public final void setEmployeeID(final int employeeIDT) {
        this.employeeID = employeeIDT;
    }
}
