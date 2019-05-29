package com.lexkane.notes.controller;

import com.lexkane.notes.model.User;
import com.lexkane.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/login"})
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String checkUser(@ModelAttribute("userFromServer") User user, Model model) {
        if (userService.checkUser(user.getEmail(), user.getPassword())) {
            return "notes";
        }
        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignUpPage() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpUser(@ModelAttribute("userFromSignUp") User user) {
        userService.insertUser(user.getUsername(), user.getPassword(), user.getEmail());
        return "notes";
    }
}
