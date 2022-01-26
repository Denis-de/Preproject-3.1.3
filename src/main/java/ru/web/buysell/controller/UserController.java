package ru.web.buysell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.web.buysell.service.UserService;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUser(Model model, Principal principal) {
        model.addAttribute("users", userService.getUserByName(principal.getName()));
        return "user-page";
    }

   /* @GetMapping("/users")
    public String getUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-page";
    }*/

    @GetMapping("/users/{id}")
    public String showUserId(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("users", userService.readUser(id));
        return "user-page";
    }
}
