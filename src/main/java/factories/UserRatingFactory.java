package factories;

import domain.UserRating;

import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserRatingFactory  {
    public static UserRating getUserRating(Map<String, String> values, int rating) {


        UserRating userRating = new UserRating.Builder()
                .id(values.get("id"))
                .rating(rating)
                .username(values.get("userName"))
                .build();

        return userRating;
    }
}
