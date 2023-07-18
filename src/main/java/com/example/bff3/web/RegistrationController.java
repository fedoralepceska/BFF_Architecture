package com.example.bff3.web;

import com.example.bff3.model.User;
import com.example.bff3.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Return the register.html Thymeleaf template
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("user") User user) {
        // Set the user's password and encode it before saving to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Assuming you want to enable the user by default upon registration
        user.setEnabled(true);

        userService.saveUser(user);
        return "redirect:/login"; // Redirect to the login page after successful registration
    }
}
