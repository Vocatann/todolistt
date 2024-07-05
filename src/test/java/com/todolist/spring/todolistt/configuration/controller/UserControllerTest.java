package com.todolist.spring.todolistt.configuration.controller;

import com.todolist.spring.todolistt.core.domain.dto.UserDTO;
import com.todolist.spring.todolistt.core.usecase.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testAddUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setUsername("john_doe");
        userDTO.setEmail("john@example.com");
        userDTO.setPassword("password");

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"username\":\"john_doe\",\"email\":\"john@example.com\",\"password\":\"password\"}"))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$.username", is("john_doe")))
                .andExpect((ResultMatcher) jsonPath("$.email", is("john@example.com")))
                .andExpect((ResultMatcher) jsonPath("$.password", is("password")));

        verify(userService, times(1)).saveUser(any(UserDTO.class));
    }
}
