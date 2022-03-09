package ru.web.buysell.init;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.web.buysell.model.Role;
import ru.web.buysell.model.User;
import ru.web.buysell.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {

    private final UserService userService;

    public DBInit(UserService userService) {
        this.userService = userService;
    }


    @PostConstruct
    @Transactional
    public void myInit() {
        Set<Role> setAdmin = new HashSet<>();
        Set<Role> setUser = new HashSet<>();
        setAdmin.add(new Role("ADMIN"));
        User admin = new User("ADMIN", "ADMIN", "ADMIN", 21, "admin@mail.ru", "aaa", setAdmin);
        setUser.add(new Role("USER"));
        User user = new User("USER", "USER", "USER", 22, "user@mail.ru", "uuu", setUser);
        userService.createUser(admin);
        userService.createUser(user);
    }
}
