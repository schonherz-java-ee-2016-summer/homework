/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonerz.training.main;

import hu.schonerz.training.thread.Report;
import net.sourceforge.cobertura.CoverageIgnore;

/**
 *
 * @author Roli
 */
@CoverageIgnore
public class Main {

    public static void main(String[] args) {
        homework();
    }

    public static void homework() {
        Report r = new Report();
        r.run();
    }

}
