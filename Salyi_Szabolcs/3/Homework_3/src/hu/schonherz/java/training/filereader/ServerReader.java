package hu.schonherz.java.training.filereader;

import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.ServerFactory;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by Home on 2016. 07. 12..
 */
public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> readServers(){
        List<Server> result = new LinkedList<Server>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            getServers(result, bufferedReader);

        } catch (IOException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corrupted");
        }

        return result;
    }

    private static void getServers(List<Server> result, BufferedReader bufferedReader) throws IOException, MyException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] attributes = line.split(",");
            if (attributes.length < 2) {
                throw new MyException();
            }

            Server server = createServerFromAttributes(attributes);
            result.add(server);
        }
    }

    private static Server createServerFromAttributes(String[] attributes) throws NullPointerException{

        if(attributes[3].equals("STOPPED") || attributes[3].equals("DATASTOPPED")) {
            Server server = ServerFactory.getServer(attributes[2]);
            server.setId(Integer.parseInt(attributes[0]));
            server.setName(attributes[1]);
            return server;
        }
        return null;
    }

}
