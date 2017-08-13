package repositories;

import domain.UserRating;
import factories.UserRatingFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repositories.impl.UserRatingRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserRatingRepositoryTest {




    Map<String,String> values;
    UserRatingRepository repository;
    UserRating userRating;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = UserRatingRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("id","1");
        values.put("userName","Jean");
        
    }

    @Test
    public void create() throws Exception {
        UserRating userRating = UserRatingFactory.getUserRating(values, 2 );
        repository.create(userRating);
        assertEquals("Jean",userRating.getUsername());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        UserRating readiuserRating = repository.read("1");
        assertEquals("Jean",readiuserRating.getUsername());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        UserRating userRating = repository.read("1");
        UserRating newUserRating = new UserRating.Builder()
                .username("Love2")
                .id(values.get("id"))
                .build();
        repository.update(newUserRating);
        UserRating UpdateUserRating = repository.read("1");
        assertEquals("Love2",UpdateUserRating.getUsername());
    }

    @Test (dependsOnMethods = "update")
    public void delete() throws Exception {
        repository.delete("1");
        UserRating iuserRating = repository.read("1");
        assertNull(iuserRating);
    }


}
