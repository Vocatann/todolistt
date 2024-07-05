package com.todolist.spring.todolistt.core.usecase;

import com.todolist.spring.todolistt.core.domain.dto.UserDTO;
import com.todolist.spring.todolistt.core.domain.model.User;
import com.todolist.spring.todolistt.core.domain.repository.GenericRepository;
import com.todolist.spring.todolistt.core.usecase.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private GenericRepository<User, Long> userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setUsername("todolist");
        dto.setPassword("password");
        dto.setEmail("todolist@gmail.com");

        User user = new User();
        user.setId(1L);
        user.setUsername("todolist");
        user.setPassword("password");
        user.setEmail("todolist@gmail.com");

        userService.saveUser(dto);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();

        assertEquals(dto.getId(), savedUser.getId());
        assertEquals(dto.getUsername(), savedUser.getUsername());
        assertEquals(dto.getEmail(), savedUser.getEmail());
        assertEquals(dto.getPassword(), savedUser.getPassword());
    }
}