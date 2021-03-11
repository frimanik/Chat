/*package com.example.chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Controller

public class LoginController  {

    @GetMapping("/login?error=1")
    public String login(Model model, HttpServletRequest httpServletRequest) {

        AuthenticationException error = new AuthenticationException();
        error = (AuthenticationException)httpServletRequest.getSession();
        model.addAttribute("error",error);
        return "login";
    }
}
*/