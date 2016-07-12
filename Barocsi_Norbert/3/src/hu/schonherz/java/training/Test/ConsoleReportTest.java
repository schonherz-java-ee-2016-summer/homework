package hu.schonherz.java.training.Test;

import hu.schonherz.java.training.thread.ServerReaderThread;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mindfield on 2016. 07. 12..
 */
public class ConsoleReportTest {
    @Test
    public void consoleReportListSize(){
        List<String> testList = ServerReaderThread.serversAndSystemAdministratorsListConsoleReport();
        int expected = testList.size();
        int result = 3;

        assertEquals(expected, result);
    }
    @Test
    public void consoleReportListElementTest(){
        List<String> testList = ServerReaderThread.serversAndSystemAdministratorsListConsoleReport();
        String expected = testList.get(0).concat("\n"+testList.get(1).concat("\n"+testList.get(2)));
        String result = "SQLNWEB01 - \nSysadmin Ian\nSysadmin Ken";

        assertEquals(expected, result);
    }

}
