package services;

import domain.Bid;
import domain.Item;
import domain.User;
import factories.BidFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.BidServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;


/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class BidServiceTest {
    BidService service;
    Map<String,String> values;

    User user;
    Item item;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new BidServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","love");
    }

    @Test
    public void testCreate() throws Exception {
        Bid obj = BidFactory.getBid(values, item, user);
        service.create(obj);
        assertEquals("love",obj.getUsername());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Bid readobj = service.read("1");
        assertEquals("love",readobj.getUsername());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Bid obj = service.read("1");
        Bid newBid = new Bid.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        service.update(newBid);
        Bid UpdateBid = service.read("1");
        assertEquals("Love2",UpdateBid.getUsername());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        Bid obj = service.read("1");
        assertNull(obj);
    }
}
