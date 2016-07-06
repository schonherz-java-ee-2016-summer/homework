package hu.schonherz.java.training.thread;

import hu.schonherz.java.training.firereader.ReadServers;

/**
 * Sample custom Thread class.
 * 
 * When ran, it will read employees from a file
 * and print the value of their fields three times.
 */
public class ServerReaderThread extends Thread {

    @Override
    public void run() 
    {
        int i = 0;

        while (i < 100)
        {
            i++;
            ReadServers.read();
            try 
            {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
