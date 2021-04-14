package springWEBMVC_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springWEBMVC_hibernate.dao.UserDao;
import springWEBMVC_hibernate.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional()
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(Long id, String name, String secondName) {
        userDao.updateUser(id, name, secondName);
    }
    @Override
    @Transactional()
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
