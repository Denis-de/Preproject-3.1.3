package ru.web.buysell.repository;

import ru.web.buysell.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(Long id);

    User deleteUser(Long id);

    User getUserByName(String name);
}