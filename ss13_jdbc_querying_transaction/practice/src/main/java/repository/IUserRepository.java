package repository;

import module.User;

import java.util.List;

public interface IUserRepository {
    List<User> findByAll();

    boolean add(User user);

    boolean update(User user);

    User selectUser(int id);

    boolean deleteUser(int id);

    List<User> findByCountry(String country);

    List<User> sortByName();
}
