package springWEBMVC_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springWEBMVC_hibernate.entity.User;
import springWEBMVC_hibernate.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String listPerson(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String infoPerson(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "info";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping()
    public String addPerson(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add";

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "update";

        userService.updateUser(id, user.getName(), user.getSecondName());
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
