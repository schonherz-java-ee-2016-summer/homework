package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.server.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 03..
 */
public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readFromTextFile(){
        List<Server> result = new ArrayList<>();

        try(BufferedReader bufferedreader = new BufferedReader(new FileReader(file))){

            serversAddList(result, bufferedreader);

        }catch (IOException e){
            System.out.println("io error");
        }

        return result;
    }

    private static void serversAddList(List<Server> result, BufferedReader bufferedreader) throws IOException{
        String line;

        while((line = bufferedreader.readLine()) != null){
            String[] attributes = line.split(",");

            if("STOPPED".equals(attributes[3]) || "DATABASESTOPPED".equals(attributes[3]))
                result.add(ServerFactory.getServer(attributes));
        }

    }

}
