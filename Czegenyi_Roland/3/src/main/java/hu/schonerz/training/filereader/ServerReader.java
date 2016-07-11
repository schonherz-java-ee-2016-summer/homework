/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonerz.training.filereader;

/**
 *
 * @author Roli
 */
import hu.schonerz.training.server.Server;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ServerReader {

    private static final String FILENAME = "servers.txt";
    private static final ClassLoader CLASSLOADER = ServerReader.class.getClassLoader();
    private static final File FILE = new File(CLASSLOADER.getResource(FILENAME).getFile());

    public static List<Server> read() {
        List<Server> result = new LinkedList<>();
        try (Scanner sc = new Scanner(FILE)) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                result.add(lineProcessing(line));

            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } catch (MyException e) {
            System.out.println("File is corrupted");
        }
        return result;
    }

    public static Server lineProcessing(String line) throws MyException {
        String[] attributes = line.split(",");

        if (attributes.length < 4) {
            throw new MyException();
        }

        int id = Integer.parseInt(attributes[0]);
        String name = attributes[1];
        String type = attributes[2];
        String status = attributes[3];

        return (serverCreator(id, name, type, status));

    }

    public static Server serverCreator(int id, String... s) {

        return new Server(id, s[0], s[1], s[2]);
    }
}
