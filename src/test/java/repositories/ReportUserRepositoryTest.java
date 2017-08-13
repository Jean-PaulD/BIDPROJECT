package repositories;

import domain.ReportUser;
import domain.User;
import factories.ReportUserFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.impl.ReportUserRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class ReportUserRepositoryTest {



    Map<String,String> values;
    ReportUserRepository repository;
    User user;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = ReportUserRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","Jean");
    }

    @Test
    public void create() throws Exception {
        ReportUser reportUser = ReportUserFactory.getReportUser(values, user, 10);
        repository.create(reportUser);
        assertEquals("Jean",reportUser.getUsername());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        ReportUser readireportUser = repository.read("1");
        assertEquals("Jean",readireportUser.getUsername());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        ReportUser reportUser = repository.read("1");
        ReportUser newReportUser = new ReportUser.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        repository.update(newReportUser);
        ReportUser UpdateReportUser = repository.read("1");
        assertEquals("Love2",UpdateReportUser.getUsername());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        ReportUser ireportUser = repository.read("1");
        assertNull(ireportUser);
    }

}
