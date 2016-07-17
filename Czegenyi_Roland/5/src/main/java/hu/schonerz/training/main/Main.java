package hu.schonerz.training.main;

import hu.schonerz.training.thread.Report;
import net.sourceforge.cobertura.CoverageIgnore;

/**
 * Main class.
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
