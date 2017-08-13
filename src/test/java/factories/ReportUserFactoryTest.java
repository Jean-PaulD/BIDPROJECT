package factories;

import domain.ReportUser;
import domain.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class ReportUserFactoryTest {

    private Map<String,String> values;
    private User user;

    @BeforeMethod
    public void setUp() throws Exception {
        User newUser = new User.Builder()
                .username("JP")
                .build();
        user = newUser;

        values = new HashMap<String, String>();
        values.put("id","reportuserid");
        values.put("userName","Jean");
    }

    @Test
    public void testGetReportUser() throws Exception {
        ReportUser reportUser = ReportUserFactory.getReportUser(values, user, 3);
        assertEquals( "Jean", reportUser.getUsername());
    }

}