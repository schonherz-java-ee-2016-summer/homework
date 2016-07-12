import hu.schonherz.java.training.pojo.SystemAdministrator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static hu.schonherz.java.training.firereader.SystemAdministratorReader.readFromTextFile;

/**
 * Created by Attila on 2016.07.11..
 */

public class SystemAdministratorReaderTest {
    String filepath = "files"+File.separator+"anAdmins.txt";
    File file = new File(filepath);

    @Test
    public void shouldSizeTheSame(){
        String anAdmin = "Holhós Attila,1,1,3,4";
        List<SystemAdministrator>  adminList = null;
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(anAdmin);
            fileWriter.flush();
            fileWriter.close();
            adminList = readFromTextFile(filepath);
        } catch (IOException e){
            System.out.println("IOException.");
        }
        assertTrue(adminList.size()==1);
    }

}
