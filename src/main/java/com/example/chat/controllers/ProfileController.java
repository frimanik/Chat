package com.example.chat.controllers;

import com.example.chat.entity.Message;
import com.example.chat.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/profile")
@Controller
public class ProfileController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("{username}")
    public String showProfile(@PathVariable String username, Model model){
        List<Message> messageList = messageRepo.findAll();
        List<Message> outputList = new ArrayList<>();
        for(Message message:messageList){
            if(message.getAuthorName().equals(username))
                outputList.add(message);
        }
        model.addAttribute("outputList", outputList);
        return "profile";
    }
}
