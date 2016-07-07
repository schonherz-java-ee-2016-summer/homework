package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
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

    public static List<RunningServer> readFromTextFile(){
        List<RunningServer> servers = new ArrayList<RunningServer>();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!= null){
                String[] seged = line.split(",");
                RunningServer rs = new RunningServer(Integer.parseInt(seged[0]),seged[1],seged[2],toBoolean(seged[3]));
                servers.add(rs);
            }
        } catch (FileNotFoundException e){
            System.out.println("The file is not found!");
        } catch (IOException e){
            System.out.println("We got an IO Exception!");
        } finally{
            try {
                br.close();
            } catch (IOException e){
                System.out.println("We got an IO Exception to BufferReader, when I want to close!");
            }
        }
        return servers;
    }

    public static boolean toBoolean (String s){
        return "RUNNING".equals(s);
    }


}
