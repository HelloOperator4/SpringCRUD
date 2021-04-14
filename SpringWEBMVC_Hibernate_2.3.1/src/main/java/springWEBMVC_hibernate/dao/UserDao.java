package springWEBMVC_hibernate.dao;

import springWEBMVC_hibernate.entity.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(Long id, String name, String secondName);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUser(Long id);

}
