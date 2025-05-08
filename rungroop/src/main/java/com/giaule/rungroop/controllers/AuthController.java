package com.giaule.rungroop.controllers;

import com.giaule.rungroop.dtos.RegistrationDto;
import com.giaule.rungroop.models.UserEntity;
import com.giaule.rungroop.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("registration", registrationDto);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registration") RegistrationDto registrationDto,
                           BindingResult bindingResult,
                           Model model) {
        UserEntity existingUserWithEmail = userService.findByEmail(registrationDto.getEmail());
        if(existingUserWithEmail != null && existingUserWithEmail.getEmail() != null && existingUserWithEmail.getUsername() != null) {
            bindingResult.rejectValue("email", "error.email", "user with given email already exists");
        }

        UserEntity existingUserWithUsername = userService.findByUserName(registrationDto.getUsername());
        if(existingUserWithUsername != null && existingUserWithUsername.getEmail() != null && existingUserWithUsername.getUsername() != null) {
            bindingResult.rejectValue("username", "error.username","user with given username already exists");
        }

        if(bindingResult.hasErrors()) {
            return "register";
        }

        userService.saveUser(registrationDto);

        return "redirect:/clubs?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
