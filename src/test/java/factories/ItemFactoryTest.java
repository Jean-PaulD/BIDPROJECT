package factories;

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
public class ItemFactoryTest {


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
                .itemName("toilet")
                .itemValue(900)
                .comment("")
                .description("this is a toilet")
                .currentBidOwner(user.getUsername())
                .build();

                item = newItem;

        values = new HashMap<String, String>();
        values.put("id","commentID");
        values.put("comment","this is a toilet");
        values.put("description",item.getDescription());
        values.put("highestBidder", item.getCurrentBidOwner());
        values.put("value", ""+item.getItemValue());

    }

    @Test
    public void testGetItem() throws Exception {
        Item item1 = ItemFactory.getItem(values, 900, user);
        assertEquals( "this is a toilet", item.getDescription());

    }

}