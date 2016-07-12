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

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readServersFromText(){
        List<Server> servers = new ArrayList<Server>();
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line=bufferedReader.readLine())!= null){
                String[] seged = line.split(",");
                Server server = new Server(Integer.parseInt(seged[0]),seged[1],seged[2],seged[3]);
                servers.add(server);
            }
        } catch (FileNotFoundException e){
            System.out.println("The file is not found!");
        } catch (IOException e){
            System.out.println("We got an IO Exception!");
        } finally{
            try {
                bufferedReader.close();
            } catch (IOException e){
                System.out.println("We got an IO Exception to BufferReader, when I want to close!");
            }
        }
        return servers;
    }
}
