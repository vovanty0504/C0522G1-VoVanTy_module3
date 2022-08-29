package repository;

import module.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    List<User> findByAll();

    boolean add(User user);

    boolean update(User user);

    User selectUser(int id);

    boolean deleteUser(int id);

    List<User> findByCountry(String country);

    List<User> sortByName();

    User getUserById(int id);

    boolean insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);
}
