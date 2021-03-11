package com.example.chat.controllers;

import com.example.chat.entity.Role;
import com.example.chat.entity.User;
import com.example.chat.repos.MessageRepo;
import com.example.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageRepo messageRepo;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping ("{user}")
    public String userEditForm(@PathVariable User user,Model model){
        model.addAttribute("id",user.getId());
        model.addAttribute("user",user);
        model.addAttribute("roles",Role.values());
        return "userEdit";
    }
 @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userEditSave(
            @RequestParam String username,
            @RequestParam Map<String,String>form,
            @RequestParam("userId")User user){

        userService.saveUser(user,user.getUsername(),form);
        return "redirect:/user";
    }

  /*
    public messageRepo GetMessages(User currentuser, MessageRepo messagerepo){
    if (messagerepo.foreach.message.getAuthorName.equals(currentuser.getUserName())
        messagerepo2.save();
        return messagerepo2;
    }
   */
}


