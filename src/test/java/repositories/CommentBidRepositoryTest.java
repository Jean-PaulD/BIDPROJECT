package repositories;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */


import domain.CommentBid;
import domain.Item;
import domain.User;
import factories.CommentBidFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.impl.CommentBidRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class CommentBidRepositoryTest {


    Map<String,String> values;
    CommentBidRepository repository;
    Item item;
    User user;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = CommentBidRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("comment","cool product");
        values.put("userName","love");
    }

    @Test
    public void create() throws Exception {
        CommentBid commentBid = CommentBidFactory.getCommentBid(values, item, user);
        repository.create(commentBid);
        assertEquals("love",commentBid.getUsername());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        CommentBid readcommentBid = repository.read("1");
        assertEquals("love", readcommentBid.getUsername());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        CommentBid commentBid = repository.read("1");
        CommentBid newCommentBid = new CommentBid.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        repository.update(newCommentBid);
        //System.out.println("repository.read   " + repository.read("1").getUsername());
        CommentBid UpdateCommentBid = repository.read("1");
        // System.out.println("updatedcommentBid   " + UpdateCommentBid.getUsername());
        assertEquals(UpdateCommentBid.getUsername(), "Love2");
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        CommentBid commentBid = repository.read("1");
        assertNull(commentBid);
    }


}
