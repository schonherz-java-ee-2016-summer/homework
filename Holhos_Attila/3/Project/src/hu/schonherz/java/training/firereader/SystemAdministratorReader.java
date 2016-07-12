package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.pojo.SystemAdministrator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.05..
 */

public class SystemAdministratorReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    public static List<SystemAdministrator> readSystemAdminFromText(String filepath){
        List<SystemAdministrator> systemAdmins = new ArrayList<SystemAdministrator>();

        BufferedReader bufferedReader = null;
        File file = new File(filepath);
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line=bufferedReader.readLine())!=null){
                systemAdmins.add(createAnAdmin(line));
            }
        } catch(FileNotFoundException e){
            System.out.println("The file is not found!");
        } catch(IOException e){
            System.out.println("It is an IO Exception.");
        } finally{
        try {
            bufferedReader.close();
        } catch (IOException e){
            System.out.println("We got an IO Exception to BufferReader, when I want to close!");
        }
    }
        return systemAdmins;
    }

    public static SystemAdministrator createAnAdmin(String line){
        String[] seged = line.split(",");
        List<Integer> adminServers = new ArrayList<Integer>();
        for(int i=2;seged.length>i;i++) {
            adminServers.add(Integer.parseInt(seged[i]));
        }
        return new SystemAdministrator(seged[0],Integer.parseInt(seged[1]),adminServers);
    }
}
