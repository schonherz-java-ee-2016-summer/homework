package hu.schonherz.java.training.firereader;

/**
 * Created by Lenovo on 2016.07.04..
 */

import hu.schonherz.java.training.server.Server2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server2> readFromTextFile() {
        List<Server2> result = new ArrayList<Server2>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                result.add(new Server2(Integer.parseInt(attributes[0]), attributes[1], attributes[2], attributes[3]) {
                });
            }

        } catch (IOException e) {
            System.out.println("io error");
        }

        return result;
    }
}
