package com.example.chat.service;

import com.example.chat.entity.Message;
import com.example.chat.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chat.repos.MessageRepo;


import java.util.List;

@Service
public class MessageService   {
    @Autowired
    MessageRepo messageRepo;

    public void deleteMessage(Integer id){
        messageRepo.deleteById(id);
    }
}
