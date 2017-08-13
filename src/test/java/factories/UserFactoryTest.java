package factories;

import domain.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserFactoryTest {

    private Map<String,String> values;
    //private User user;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","userid1");
        values.put("userName","Jean");
    }

    @Test
    public void testGetUser() throws Exception {
        User user = UserFactory.getUser(values, 10);
        assertEquals(user.getUsername(),"Jean");
    }

}