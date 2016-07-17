package hu.schonherz.java.training.thread;
/**
 *
 */
public class SynchronizationTest extends Thread {
    /**
     *
     */
    private final int number;
    /**
     *
     */
    static final int CIKLUS = 5;
    /**
     *
     */
    private static SynchronizedObject synchronizedObject =
            new SynchronizedObject();

    /**
     *
     * @param numberR num
     */
    public SynchronizationTest(final int numberR) {
        super();
        this.number = numberR;
    }

    /**
     *
     */
    @Override
    public final void run() {
        int i = 0;
        synchronized (synchronizedObject) {
            while (i < CIKLUS) {
                i++;
                System.out.println(number + " - "
                        + synchronizedObject.getNum());
            }
        }
    }

    /**
     *
     */
    @Override
        public final synchronized void start() {
            System.out.println(number + ". started");
            super.start();
        }
}
