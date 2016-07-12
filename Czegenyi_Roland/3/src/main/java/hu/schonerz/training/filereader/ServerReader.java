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
// TODO: Create FileFactory for reading from files

    public static List<Server> readFile() {
        String FILENAME = "servers.txt";

        List<Server> result = new LinkedList<>();
        try (Scanner sc = new Scanner(createFile(FILENAME))) {

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

    public static File createFile(String FILENAME) {
        ClassLoader CLASSLOADER = ServerReader.class.getClassLoader();
        File FILE = new File(CLASSLOADER.getResource(FILENAME).getFile());
        return FILE;
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
