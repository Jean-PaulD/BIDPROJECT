package repositories;

import domain.User;

/**
 * Created by Jean-Paul D on 2017-08-13.
 */
public interface UserRepository {

    User create( User obj);

    User read(String id);

    User update( User obj);

    void delete(String id);
}
