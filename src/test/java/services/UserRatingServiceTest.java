package services;

import domain.Item;
import domain.User;
import domain.UserRating;
import factories.UserRatingFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.UserRatingServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserRatingServiceTest {


    UserRatingService service;
    Map<String,String> values;

    User user;
    Item item;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new UserRatingServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","love");
    }

    @Test
    public void testCreate() throws Exception {
        UserRating obj = UserRatingFactory.getUserRating(values, 10 );
        service.create(obj);
        assertEquals("love",obj.getUsername());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        UserRating readobj = service.read("1");
        assertEquals("love",readobj.getUsername());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        UserRating obj = service.read("1");
        UserRating newUserRating = new UserRating.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        service.update(newUserRating);
        UserRating UpdateUserRating = service.read("1");
        assertEquals("Love2",UpdateUserRating.getUsername());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        UserRating obj = service.read("1");
        assertNull(obj);
    }


}
