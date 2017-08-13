package factories;

import domain.Bid;
import domain.CommentBid;
import domain.Item;
import domain.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class CommentBidFactoryTest {

    private Map<String,String> values;
    private Item item;
    private User user;

    @BeforeMethod
    public void setUp() throws Exception {

        User newUser = new User.Builder()
                .username("JP")
                .build();
        user = newUser;

        Item newItem = new Item.Builder()
                .id("item1")
                .build();
        item = newItem;

        values = new HashMap<String, String>();
        values.put("id","commentID");
        values.put("comment","this is a bad product");
        values.put("itemId",item.getid());
        values.put("userName", user.getUsername());
    }


    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetCommentBid() throws Exception {
        CommentBid commentBid = CommentBidFactory.getCommentBid(values, item, user);
        assertEquals(commentBid.getItemId(), "item1" );

    }

}