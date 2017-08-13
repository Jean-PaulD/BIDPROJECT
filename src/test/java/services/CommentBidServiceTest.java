package services;

import domain.CommentBid;
import domain.Item;
import domain.User;
import factories.CommentBidFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.CommentBidServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class CommentBidServiceTest {
    CommentBidService service;
    Map<String,String> values;

    User user;
    Item item;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new CommentBidServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","love");
    }

    @Test
    public void testCreate() throws Exception {
        CommentBid obj = CommentBidFactory.getCommentBid(values, item, user);
        service.create(obj);
        assertEquals("love",obj.getUsername());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        CommentBid readobj = service.read("1");
        assertEquals("love",readobj.getUsername());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        CommentBid obj = service.read("1");
        CommentBid newCommentBid = new CommentBid.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        service.update(newCommentBid);
        CommentBid UpdateCommentBid = service.read("1");
        assertEquals("Love2",UpdateCommentBid.getUsername());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        CommentBid obj = service.read("1");
        assertNull(obj);
    }
}
