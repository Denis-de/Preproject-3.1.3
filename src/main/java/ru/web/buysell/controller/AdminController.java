package ru.web.buysell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.web.buysell.model.User;
import ru.web.buysell.service.UserService;

import java.util.List;

@Controller
public class AdminController {
    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String showAllUsers(Model model) {
        List<User> user = userService.getAllUsers();
        model.addAttribute("users", user);
        return "admin-page";
    }

    @GetMapping("/user-create")
    public String addUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String addUser(User user) {
        userService.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("user-delete/{id}")
    public String dropUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user-update/{id}")
    public String editUserForm(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String editUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
