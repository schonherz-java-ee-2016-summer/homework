/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonerz.training.main;

import hu.schonerz.training.filereader.ServerReader;
import hu.schonerz.training.filereader.SysAdminReader;
import hu.schonerz.training.pojo.SystemAdministrator;
import hu.schonerz.training.server.Server;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Roli
 */
public class Main {

    public static void main(String[] args) {
        List<Server> server = ServerReader.read();
        List<SystemAdministrator> admin = SysAdminReader.read();
//proba
        for (Server s : server) {
            System.out.println(s.getName());
        }
        for (SystemAdministrator a : admin) {
            System.out.println(a.getServers());
        }

    }

}
