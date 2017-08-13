package factories;

import domain.User;

import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-12.
 */
public class UserFactory {

    public static User getUser(Map<String, String> values, int reportCounter) {


        User user = new User.Builder()
                .id(values.get("id"))
                .username(values.get("userName"))
                .firstname(values.get("firstName"))
                .lastName(values.get("lastName"))
                .password(values.get("password"))
                .reportCounter(reportCounter)
                .userType(values.get("userType"))
                .build();

        return user;
    }
}

