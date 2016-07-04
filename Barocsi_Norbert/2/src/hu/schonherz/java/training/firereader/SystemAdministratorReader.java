package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;
import hu.schonherz.java.training.server.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 03..
 */
public class SystemAdministratorReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> readFromTextFile(){
        List<SystemAdministrator> result = new ArrayList<>();

        BufferedReader bufferedreader = null;

        try{
            bufferedreader = new BufferedReader(new FileReader(file));
            String line;

            while((line = bufferedreader.readLine()) != null){
                String [] attributes = line.split(",");
                List<Server> servers = ServerReader.readFromTextFile();
//
//                for (int i = 2; i < attributes.length; i++){
//                    servers.add(Integer.parseInt(attributes[i]));
//                }
                result.add(new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), servers));
            }

        }catch (IOException e){
            System.out.println("io error");
        }

        return result;
    }
}
