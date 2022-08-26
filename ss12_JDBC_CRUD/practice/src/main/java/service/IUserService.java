package service;

import modle.User;

import java.util.List;

public interface IUserService {
    List<User> findByAll();

    boolean add(User user);

    User selectUser(int id);

    boolean update(User user);

    boolean deleteUser(int id);


    List<User> sortByName();

    List<User> findByCountry(String name);
}
