package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static Server createServer(int id, String name, String type, String status){
        if("Win".equals(type)){
            return new WindowsDatabaseServer(id, name, type, WindowsDatabaseServer.Status.valueOf(status));
        } else if("LinuxWeb".equals(type)){
            return new LinuxWebServer(id, name, type, LinuxWebServer.Status.valueOf(status));
        } else if ("LinuxDBandWEB".equals(type)){
            return new LinuxDatabaseAndWebServer(id, name, type, LinuxDatabaseAndWebServer.Status.valueOf(status));
        }
        return null;
    }

    public static List<Server> readFromTextFile(){
        List<Server> result = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] attributes = line.split(",");

                result.add(createServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], attributes[3]));
            }
        }catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        }catch (IOException e){
            System.out.println("File is corrupted.");
        }

        return result;
    }
}