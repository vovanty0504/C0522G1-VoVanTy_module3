package service;

import module.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> findByAll();

    boolean add(User user);

    User selectUser(int id);

    boolean update(User user);

    boolean deleteUser(int id);


    List<User> sortByName();

    List<User> findByCountry(String name);

    User getUserById(int id);

    boolean insertUserStore(User user) throws SQLException;
}
