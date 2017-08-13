package repositories;

import domain.Item;
import domain.User;
import factories.ItemFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.impl.ItemRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class ItemRepositoryTest {


    Map<String,String> values;
    ItemRepository repository;
    User user;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = ItemRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("comment","this toilet is good");
        values.put("description", "this is a toilet");
        values.put("highestBidder", "Jet Lee");
        values.put("value", ""+100);
    }

    @Test
    public void create() throws Exception {
        Item item = ItemFactory.getItem(values, 100, user);
        repository.create(item);
        assertEquals("this is a toilet",item.getDescription());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Item readiitem = repository.read("1");
        assertEquals("this is a toilet",readiitem.getDescription());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Item item = repository.read("1");
        Item newItem = new Item.Builder()
                .username("Love2")
                .description("This is a towel")
                .id(values.get("id"))
                .build();
        repository.update(newItem);
        //System.out.println("repository.read   " + repository.read("1").getUsername());
        Item UpdateItem = repository.read("1");
        // System.out.println("updatediitem   " + UpdateItem.getUsername());
        assertEquals("This is a towel",UpdateItem.getDescription());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        Item iitem = repository.read("1");
        assertNull(iitem);
    }



}
