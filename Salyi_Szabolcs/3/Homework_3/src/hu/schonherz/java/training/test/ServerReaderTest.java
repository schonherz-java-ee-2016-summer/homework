package hu.schonherz.java.training.test;

import hu.schonherz.java.training.filereader.ServerReader;
import hu.schonherz.java.training.server.Server;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Home on 2016. 07. 12..
 */
public class ServerReaderTest {

    @Test
    public void shouldReturnRightLenght(){
        Assert.assertEquals(4,ServerReader.readServers().size());
    }

    @Test
    public void shouldCountOnlyStopped(){
        List<Server> servers = ServerReader.readServers();
        int count=0;
        for(Server server : servers){
            if(server!=null) {
                count++;
            }
        }
        Assert.assertEquals(2,count);
    }

}
