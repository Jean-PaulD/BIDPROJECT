package services.Impl;

import domain.User;
import repositories.UserRepository;
import repositories.impl.UserRepositoryImpl;
import services.UserService;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserServiceImpl implements UserService {

    private static UserServiceImpl service = null;

    UserRepository repository = UserRepositoryImpl.getInstance();

    public static UserServiceImpl getInstance() {
        if (service == null)
            service = new UserServiceImpl();
        return service;
    }

    public User create(User obj) {
        return repository.create(obj);
    }

    public User read(String id) {
        return repository.read(id);
    }

    public User update(User obj) {
        return repository.update(obj);
    }

    public void delete(String id) {
        repository.delete(id);

    }

}