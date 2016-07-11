package hu.schonherz.java.training.filereader;

import java.io.File;

/**
 * Created by Nutty on 2016.07.11..
 */
public class FileFactory {
    private static File instance = null;

    public static File getInstance(String path) {
        try {
            instance = new File(FileFactory.class.getClassLoader().getResource(path).getFile());
        } catch (NullPointerException npe) {
            System.out.println(path + " is not found.");
        }
        return instance;
    }
}
