package hu.schonherz.java.training.main;

import hu.schonherz.java.training.firereader.Observer;

/**
 *
 */
@SuppressWarnings("unused")
public class Main {

    /**
     *
     */
    static final int CIKLUS10000 = 10000;
    /**
     *
     * @param args args
     */
    public static void main(final String[] args) {
        homework();
    }

    /**
     *
     */
    private static void homework() {
        while (true) {
            Observer.read();
            try {
                Thread.sleep(CIKLUS10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
