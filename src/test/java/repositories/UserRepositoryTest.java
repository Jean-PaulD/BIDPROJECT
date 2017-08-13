package repositories;

import domain.User;
import factories.UserFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.impl.UserRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserRepositoryTest {
    
    Map<String,String> values;
    UserRepository repository;
    User user;
    
    @BeforeMethod
    public void setUp() throws Exception {
        repository = UserRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","Jean");

    }

    @Test
    public void create() throws Exception {
        User user = UserFactory.getUser(values, 2 );
        repository.create(user);
        assertEquals("Jean",user.getUsername());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User readiuser = repository.read("1");
        assertEquals("Jean",readiuser.getUsername());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User user = repository.read("1");
        User newUser = new User.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        repository.update(newUser);
        User UpdateUser = repository.read("1");
        assertEquals("Love2",UpdateUser.getUsername());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        User iuser = repository.read("1");
        assertNull(iuser);
    }


}
