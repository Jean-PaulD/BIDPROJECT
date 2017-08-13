package repositories.impl;

import domain.UserRating;
import repositories.UserRatingRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserRatingRepositoryImpl implements UserRatingRepository {

    private static UserRatingRepositoryImpl respository = null;

    private Map<String, UserRating> userRatingTable;

    private UserRatingRepositoryImpl() {
        userRatingTable = new HashMap<String, UserRating>();
    }

    public static UserRatingRepositoryImpl getInstance(){
        if(respository==null)
            respository = new UserRatingRepositoryImpl();
        return respository;
    }

    public UserRating create(UserRating userRating) {
        userRatingTable.put(userRating.getId(),userRating);
        UserRating savedUserRating = userRatingTable.get(userRating.getId());
        return savedUserRating;
    }

    public UserRating read(String id) {
        UserRating userRating = userRatingTable.get(id);
        return userRating;
    }

    public UserRating update(UserRating userRating) {
        userRatingTable.put(userRating.getId(),userRating);
        UserRating savedUserRating = userRatingTable.get(userRating.getId());
        return savedUserRating;
    }

    public void delete(String id) {
        userRatingTable.remove(id);

    }
}
