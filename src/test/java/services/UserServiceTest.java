package services;

import domain.User;
import factories.UserFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserServiceTest {


    UserService service;
    Map<String,String> values;


    @BeforeMethod
    public void setUp() throws Exception {
        service = new UserServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","love");
    }

    @Test
    public void testCreate() throws Exception {
        User obj = UserFactory.getUser(values, 10 );
        service.create(obj);
        assertEquals("love",obj.getUsername());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        User readobj = service.read("1");
        assertEquals("love",readobj.getUsername());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        User obj = service.read("1");
        User newUser = new User.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        service.update(newUser);
        User UpdateUser = service.read("1");
        assertEquals("Love2",UpdateUser.getUsername());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        User obj = service.read("1");
        assertNull(obj);
    }


}
