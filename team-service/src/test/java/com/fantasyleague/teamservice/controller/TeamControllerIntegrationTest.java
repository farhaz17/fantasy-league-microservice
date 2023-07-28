package com.fantasyleague.teamservice.controller;

import com.fantasyleague.teamservice.service.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamController.class)
public class TeamControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @Test
    void shouldGetDefaultMessage() throws Exception {

        mockMvc.perform(get("/teams"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
