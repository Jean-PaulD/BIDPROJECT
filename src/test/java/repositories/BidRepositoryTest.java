package repositories;

import domain.Bid;
import domain.Item;
import domain.User;
import factories.BidFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.impl.BidRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class BidRepositoryTest {
    
    Map<String,String> values;
    BidRepository repository;
    User user;
    Item item;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = BidRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("itemID","itemid1");
        values.put("userName","love");
    }

    @Test
    public void create() throws Exception {
        Bid bid = BidFactory.getBid(values, item, user);
        repository.create(bid);
        assertEquals("itemid1",bid.getItemID());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Bid readbid = repository.read("1");
        assertEquals("love", readbid.getUsername());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Bid bid = repository.read("1");
        Bid newBid = new Bid.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        repository.update(newBid);
        //System.out.println("repository.read   " + repository.read("1").getUsername());
        Bid UpdateBid = repository.read("1");
        // System.out.println("updatedbid   " + UpdateBid.getUsername());
        assertEquals(UpdateBid.getUsername(), "Love2");
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Bid bid = repository.read("1");
        assertNull(bid);
    }

}