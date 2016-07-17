package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.pojo.Employee;

/**
 *
 */
public final class EmployeeReader {

    /**
     *
     */
    private static final String SUBDIRECTORY = "files";
    /**
     *
     */
    private static final String FILENAME = "employees.txt";

    /**
     *
     */
    private static File file = new File(
            SUBDIRECTORY + File.separator + FILENAME);

    /**
     *
     */
    private EmployeeReader() {
    }

    /**
     * @return List of employees which has been found in employees.txt file
     */



    public static List<Employee> read() {
        List<Employee> result = new LinkedList<Employee>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length < 2) {
                    throw new MyException();
                }
                Employee employee = new Employee(
                        attributes[0], Integer.parseInt(attributes[1]));
                result.add(employee);
            }
        } catch (IOException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corruptd");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("BufferedReader was not closed");
                }
            }
        }
        return result;
    }
}
