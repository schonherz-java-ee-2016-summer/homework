package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.05..
 */

public class ServerReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    public static List<Server> readServersFromText(String filePath){
        List<Server> servers = new ArrayList<Server>();
        BufferedReader bufferedReader = null;
        File file = new File(filePath);
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                servers.add(createServer(line));
            }
        } catch (FileNotFoundException e){
            System.out.println("The file is not found!");
        } catch (IOException e){
            System.out.println("We got an IO Exception!");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e){
                System.out.println("We got an IO Exception to BufferReader, when I want to close!");
            }
        }
        return servers;
    }


    public static Server createServer(String line){
        String[] parts = line.split(",");
        return new Server(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]);
    }
}
