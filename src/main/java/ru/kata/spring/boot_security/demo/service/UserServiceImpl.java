package ru.kata.spring.boot_security.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDao = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userDao.findById(id).get();
    }

    @Override
    public void addUser(@Valid User user) {
        userDao.save(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(@Valid User user) {
        User user1 = getUserById(user.getUserId());
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setPassword(user.getPassword());
        user1.setRole((List<Role>) user.getAuthorities());
        userDao.save(user1);
    }
}
