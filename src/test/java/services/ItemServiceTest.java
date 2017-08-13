package services;

import domain.Item;
import domain.User;
import factories.ItemFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.ItemServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class ItemServiceTest {

    ItemService service;
    Map<String,String> values;

    User user;
    Item item;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new ItemServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","love");
    }

    @Test
    public void testCreate() throws Exception {
        Item obj = ItemFactory.getItem(values, 1200, user );
        service.create(obj);
        assertEquals("love",obj.getUsername());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Item readobj = service.read("1");
        assertEquals("love",readobj.getUsername());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Item obj = service.read("1");
        Item newItem = new Item.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        service.update(newItem);
        Item UpdateItem = service.read("1");
        assertEquals("Love2",UpdateItem.getUsername());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        Item obj = service.read("1");
        assertNull(obj);
    }

}
