package hu.schonherz.java.training;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static hu.schonherz.java.training.firereader.ServerReader.createServer;
import static hu.schonherz.java.training.firereader.ServerReader.readServersFromText;
import hu.schonherz.java.training.server.Server;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Attila on 2016.07.12..
 */
public class ServerReaderTest {
    private String filepath = "aServer.txt";
    private File file = new File(filepath);

    @BeforeClass
    public void fileInitialization(){
        String aServer = "3,MySQL1,Win,STOPPED";
        String anotherServer= "1,SQL2,LinuxWeb,RUNNING";
        String otherServer= "2,SQL5,LinuxWeb,RUNNING";
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(aServer);
            fileWriter.write("\n");
            fileWriter.write(anotherServer);
            fileWriter.write("\n");
            fileWriter.write(otherServer);
            fileWriter.close();
        } catch (IOException e){
            System.out.println("IOException.");
        }
    }

    @Test(expected = NullPointerException.class)
    public void FileNotFoundExceptionTest(){
        List<Server> serverList = readServersFromText("valami.txt");
    }

    @Test
    public void shouldSizeTheSameTest(){
        List<Server> serverList = null;
        serverList = readServersFromText(filepath);

        assertTrue(serverList.size()==2);
    }

    @Test
    public void createAServer(){
        String aServer="3,MySQL1,Win,STOPPED";

        Server server = createServer(aServer);

        assertEquals(server.getID(),3);
        assertEquals(server.getName(),"MySQL1");
        assertEquals(server.getType(),"Win");
        assertEquals(server.getStatus(),"STOPPED");
    }

    @AfterClass
    public void deleteFile(){
        file.delete();
    }
}
