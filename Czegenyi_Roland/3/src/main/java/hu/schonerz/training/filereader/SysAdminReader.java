/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonerz.training.filereader;

import static hu.schonerz.training.filereader.ServerReader.createFile;
import hu.schonerz.training.pojo.SystemAdministrator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Roli
 */
public class SysAdminReader {

// TODO: Create FileFactory for reading from files
    public static List<SystemAdministrator> readFile() {
        String FILENAME = "sysadmins.txt";

        List<SystemAdministrator> result = new LinkedList<>();
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

    public static SystemAdministrator lineProcessing(String line) throws MyException {
        String[] attributes = line.split(",");

        if (attributes.length < 3) {
            throw new MyException();
        }

        String name = attributes[0];
        int id = Integer.parseInt(attributes[1]);

        List<Integer> serverIds = new ArrayList<>();

        for (int i = 2; i < attributes.length; i++) {
            serverIds.add(Integer.parseInt(attributes[i]));
        }
        return (adminCreator(name, id, serverIds));

    }

    public static SystemAdministrator adminCreator(String name, int id, List<Integer> serverIds) {
        return new SystemAdministrator(name, id, serverIds);
    }

}
