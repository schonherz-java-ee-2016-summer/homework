package hu.schonherz.java.training;

import hu.schonherz.java.training.filereader.ServerReader;
import hu.schonherz.java.training.filereader.SysAdmReader;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Nutty on 2016.07.12..
 */

public class HomeWorkTest {
    private static final String SUBDIRECTORY = "files";

    @Test
    public void shouldReturnEmptyList() {
        //Given
        String SERVERFILENAME = "emptyserver.txt";
        String SYSADMINFILENAME = "emptysysadmin.txt";
        ServerReader.setPath(SUBDIRECTORY, SERVERFILENAME);
        SysAdmReader.setPath(SUBDIRECTORY, SYSADMINFILENAME);
        //When
        int expected = 0;
        List<SystemAdministrator> actual = SysAdmReader.read();
        //Then
        Assert.assertEquals(expected, actual.size());
    }
    /*
    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWithInvalidFileNames() {
        //Given
        String SERVERFILENAME = "notexists.txt";
        String SYSADMINFILENAME = "notexists.txt";
        ServerReader.setPath(SUBDIRECTORY, SERVERFILENAME);
        SysAdmReader.setPath(SUBDIRECTORY, SYSADMINFILENAME);
        //When
        List<SystemAdministrator> actual = SysAdmReader.read();
        //Then
    }
    */
}
