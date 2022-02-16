package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String startPage(Model model) {
        model.addAttribute("User", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/newUser")
    public String newUser(@ModelAttribute("User") User user) {
        return "newUser";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("User") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("User", userService.getUserById(id));
        return "/edit";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("User") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
