package hu.schonherz.java.training.firereader;

import hu.schonherz.java.training.server.Server;
import hu.schonherz.java.training.server.ServerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> read() {
        List<Server> result = new LinkedList<Server>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            getServers(result, reader);

        } catch (IOException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corrupted");
        }

        return result;
    }

    private static void getServers(List<Server> result, BufferedReader reader) throws IOException, MyException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] attributes = line.split(",");
            if (attributes.length < 2) {
                throw new MyException();
            }

            Server server = createServerFromAttributes(attributes);
            result.add(server);
        }
    }

    private static Server createServerFromAttributes(String[] attributes) {
        Server server = ServerFactory.getServer(attributes[2]);
        server.setId(Integer.parseInt(attributes[0]));
        server.setName(attributes[1]);
        return server;
    }

}
