package hu.schonherz.java.training;

import org.junit.Test;
import static org.junit.Assert.*;
import static hu.schonherz.java.training.firereader.SystemAdministratorReader.createAnAdmin;
import static hu.schonherz.java.training.firereader.SystemAdministratorReader.readSystemAdminFromText;
import hu.schonherz.java.training.pojo.SystemAdministrator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Attila on 2016.07.11..
 */

public class SystemAdministratorReaderTest {
    private String filepath = "anAdmin.txt";
    private File file = new File(filepath);

    @Test(expected = NullPointerException.class)
    public void FileNotFoundExceptionTest(){
        List<SystemAdministrator> adminList = readSystemAdminFromText("a.txt");
    }

    @Test
    public void shouldSizeTheSameAfterReadingSystemAdmin(){
        String anAdmin = "Holhós Attila,1,1,3,4";
        List<SystemAdministrator> adminList = null;

        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(anAdmin);
            fileWriter.flush();
            fileWriter.close();
            adminList = readSystemAdminFromText(filepath);
            file.delete();
        } catch (IOException e){
            System.out.println("IOException.");
        }

        assertTrue(adminList.size()==1);
    }

    @Test
    public void createAnAdminTest(){
        String anAdmin="Holhós Attila,1,4,2";

        SystemAdministrator admin = createAnAdmin(anAdmin);

        assertEquals(admin.getName(),"Holhós Attila");
        assertTrue(admin.getServers().size()==2);
        assertTrue(admin.getServers().contains(4));
        assertTrue(admin.getServers().contains(2));
    }

}
