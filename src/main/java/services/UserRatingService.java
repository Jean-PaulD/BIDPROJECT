package services;

import domain.UserRating;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public interface UserRatingService {


    UserRating create(UserRating obj);
    UserRating read(String id);
    UserRating update(UserRating obj);
    void delete(String id);
}
