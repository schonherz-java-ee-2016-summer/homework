package hu.schonherz.java.training.filereader;

import java.io.File;

/**
 * Created by Nutty on 2016.07.11..
 * A Factory class providing a static method that gives a proper File
 */
public class FileFactory {
    private static File instance = null;

    /**
     * Gives a File from the parameter.
     *
     * @param path The path where the file is.
     * @return The actual File.
     */
    public static File getInstance(String path) {
        // try {
        instance = new File(FileFactory.class.getClassLoader().getResource(path).getFile());
        // } catch (NullPointerException npe) {
        //      System.out.println(path + " is not found.");
        //  }
        return instance;
    }
}
