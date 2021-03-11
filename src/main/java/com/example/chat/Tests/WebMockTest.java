package com.example.chat.Tests;

import com.example.chat.entity.Role;
import com.example.chat.controllers.RegistrationController;
import com.example.chat.entity.User;
import com.example.chat.repos.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;


import static com.example.chat.entity.Role.USER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegistrationController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RegistrationController controller;

    @MockBean
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void RegistrationContollerCheck() throws Exception {
        User user = new User("Test#1","Test#1",true, Collections.singleton(USER));

        mockMvc
                .perform(post("/registration")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }
}

