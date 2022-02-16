package web.dao;

import web.model.User;
import java.util.List;

public interface UserDAO {

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();
}
