package factories;

import domain.Bid;
import domain.Item;
import domain.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class BidFactoryTest {

    private Map<String,String> values;
    private Item item;
    private User user;

    @BeforeMethod
    public void setUp() throws Exception {
        User newUser = new User.Builder()
                .username("JP")
                .build();
        user = newUser;

        values = new HashMap<String, String>();
        values.put("id","bidID");
        values.put("itemID","normal");
        values.put("userName", user.getUsername());
  }

    @Test
    public void testGetBid() throws Exception {
        Bid bid = BidFactory.getBid(values, item, user);
        assertEquals("JP",bid.getUsername() );

    }

}