package services;

import domain.Item;
import domain.ReportUser;
import domain.User;
import factories.ReportUserFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.Impl.ReportUserServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class ReportUserServiceTest {

    ReportUserService service;
    Map<String,String> values;

    User user;
    Item item;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new ReportUserServiceImpl();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","love");
    }

    @Test
    public void testCreate() throws Exception {
        ReportUser obj = ReportUserFactory.getReportUser(values, user, 10 );
        service.create(obj);
        assertEquals("love",obj.getUsername());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        ReportUser readobj = service.read("1");
        assertEquals("love",readobj.getUsername());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        ReportUser obj = service.read("1");
        ReportUser newReportUser = new ReportUser.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        service.update(newReportUser);
        ReportUser UpdateReportUser = service.read("1");
        assertEquals("Love2",UpdateReportUser.getUsername());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("1");
        ReportUser obj = service.read("1");
        assertNull(obj);
    }

}
