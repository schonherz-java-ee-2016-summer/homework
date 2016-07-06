package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.RunningServer;
import hu.schonherz.java.training.server.Server;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class RunningServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static boolean parseRunning(String s) {
        return "RUNNING".equals(s);
    }

    public static List<RunningServer> read() {
        List<RunningServer> result = new LinkedList<RunningServer>();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length < 2) {
                    throw new MyException();
                }

                RunningServer server = new RunningServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], parseRunning(attributes[3]));
                result.add(server);
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
