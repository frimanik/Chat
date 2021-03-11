package com.example.chat.controllers;
//Chat rooms. And be done with it. ANd be done with it! AND BE DONW WITH IT!!!
import com.example.chat.entity.Message;
import com.example.chat.entity.User;
import com.example.chat.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private MessageRepo messageRepo;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping()
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "chat";
    }


    @Transactional
    @GetMapping("/chat/{id}")
    public String deleteMessage(@PathVariable Integer id){
        messageRepo.deleteById(id);
        return "chat";
    }

    @PostMapping("/chat")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Model model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Message message = new Message(text, tag, user);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            message.setFilename(file.getName());
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            message.setFilename(resultFilename);
        }
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages",messages);
        return "chat";
    }



    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message messageIncome(Message message
                                ){
     //   Message message = new Message(text, tag, user);
        if(message.getTag()==null){
            message.setTag("");
        }
        System.out.println(message.getText());
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        return message;
    }
}
