package repositories.impl;

import domain.User;
import repositories.UserRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public class UserRepositoryImpl implements UserRepository {

    private static UserRepositoryImpl respository = null;

    private Map<String, User> userTable;

    private UserRepositoryImpl() {
        userTable = new HashMap<String, User>();
    }

    public static UserRepositoryImpl getInstance(){
        if(respository==null)
            respository = new UserRepositoryImpl();
        return respository;
    }

    public User create(User user) {
        userTable.put(user.getId(),user);
        User savedUser = userTable.get(user.getId());
        return savedUser;
    }

    public User read(String id) {
        User user = userTable.get(id);
        return user;
    }

    public User update(User user) {
        userTable.put(user.getId(),user);
        User savedUser = userTable.get(user.getId());
        return savedUser;
    }

    public void delete(String id) {
        userTable.remove(id);

    }
}
