package springWEBMVC_hibernate.dao;

import org.springframework.stereotype.Component;
import springWEBMVC_hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.createNativeQuery("insert into users (name, secondName) values (?, ?)")
                .setParameter(1, user.getName())
                .setParameter(2, user.getSecondName())
                .executeUpdate();
    }

    @Override
    public void updateUser(Long id, String name, String secondName) {
        entityManager.createQuery("update User u set u.name = ?2, u.secondName = ?3 where u.id = ?1")
                .setParameter(2, name)
                .setParameter(3, secondName)
                .setParameter(1, id)
                .executeUpdate();
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User where id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User as  u").getResultList();
    }

    @Override
    public User getUser(Long id) {
        return (User) entityManager
                .createQuery("select u from User as u where u.id = ?1")
                .setParameter(1, id)
                .getSingleResult();
    }
}
