package services.Impl;

import domain.UserRating;
import repositories.UserRatingRepository;
import repositories.impl.UserRatingRepositoryImpl;
import services.UserRatingService;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserRatingServiceImpl implements UserRatingService {

    private static UserRatingServiceImpl service = null;

    UserRatingRepository repository = UserRatingRepositoryImpl.getInstance();

    public static UserRatingServiceImpl getInstance() {
        if (service == null)
            service = new UserRatingServiceImpl();
        return service;
    }

    public UserRating create(UserRating obj) {
        return repository.create(obj);
    }

    public UserRating read(String id) {
        return repository.read(id);
    }

    public UserRating update(UserRating obj) {
        return repository.update(obj);
    }

    public void delete(String id) {
        repository.delete(id);

    }

}