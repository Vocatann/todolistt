package com.todolist.spring.todolistt.core.domain.mapper;


import com.todolist.spring.todolistt.core.domain.dto.UserDTO;
import com.todolist.spring.todolistt.core.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest {

    @Test
    public void testToEntity() {
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setUsername("todolist");
        dto.setPassword("password");
        dto.setEmail("todolist@gmail.com");

        User user = UserMapper.toEntity(dto);

        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("todolist", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("todolist@gmail.com", user.getEmail());
    }

    @Test
    public void testToDto() {
        User user = new User();
        user.setId(1L);
        user.setUsername("todolist");
        user.setPassword("password");
        user.setEmail("todolist@gmail.com");

        UserDTO dto = UserMapper.toDto(user);

        assertNotNull(dto);
        assertEquals(1, dto.getId());
        assertEquals("todolist", dto.getUsername());
        assertEquals("password", dto.getPassword());
        assertEquals("todolist@gmail.com", dto.getEmail());
    }
}
