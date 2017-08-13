package factories;

import domain.UserRating;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserRatingFactoryTest {

    private Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
        values.put("id","userid1");
        values.put("userName","Jean");
    }

    @Test
    public void testGetUserRating() throws Exception {
        UserRating userRating = UserRatingFactory.getUserRating(values, 10);
        assertEquals(userRating.getUsername(),"Jean");
    }

}