package ru.web.buysell.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.web.buysell.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User readUser(Long id);

    User deleteUser(Long id);

    User getUserByName(String name);
}