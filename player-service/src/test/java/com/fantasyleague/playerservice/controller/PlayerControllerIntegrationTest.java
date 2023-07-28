package com.fantasyleague.playerservice.controller;

import com.fantasyleague.playerservice.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PlayerController.class)
public class PlayerControllerIntegrationTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PlayerService playerService;
//
//    @Test
//    void shouldGetDefaultMessage() throws Exception {
//
//        mockMvc.perform(get("/welcome"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Welcome Stranger")));
//    }
}
