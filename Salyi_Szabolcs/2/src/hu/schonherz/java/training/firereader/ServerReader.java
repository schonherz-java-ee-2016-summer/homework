package hu.schonherz.java.training.firereader;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
import hu.schonherz.java.training.server.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Home on 2016. 07. 05..
 */
public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static final File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readFromTextFile(){

                List<Server> result = new LinkedList<>();

                BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while((line = bufferedReader.readLine())!=null){

                String [] attributes = line.split(",");

                if(attributes.length != 4){
                    throw new MyException();
                }

                if("LinuxDBandWEB".equals(attributes[2])){
                    result.add(new LinuxDatabaseAndWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], LinuxDatabaseAndWebServer.Status.valueOf(attributes[3])));
                }else if("LinuxWeb".equals(attributes[2])){
                    result.add(new LinuxWebServer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], WebContainer.Status.valueOf(attributes[3])));
                }else if("Win".equals(attributes[2])){
                    result.add(new WindowsDatabaseServer(Integer.parseInt(attributes[0]),attributes[1],attributes[2], Database.Status.valueOf(attributes[3])));
                }

            }

        }catch (IOException e) {
            System.out.println("File not found");
        } catch (MyException e) {
            System.out.println("File is corrupted");
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                }catch (IOException e){
                    System.out.println("BufferedReader wasn't closed");
                }
            }
        }

        return result;
    }

}
