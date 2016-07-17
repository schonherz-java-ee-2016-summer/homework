package hu.schonherz.java.training.thread;
/**
 *
 */
public class SynchronizedObject {
    /**
     *
     */
    private int num = 0;

    /**
     * @return number
     */
    public final int getNum() {
        num++;
        return num;
    }
}
