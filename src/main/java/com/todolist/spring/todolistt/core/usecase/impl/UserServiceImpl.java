package com.todolist.spring.todolistt.core.usecase.impl;

import com.todolist.spring.todolistt.core.domain.dto.UserDTO;
import com.todolist.spring.todolistt.core.domain.mapper.UserMapper;
import com.todolist.spring.todolistt.core.domain.model.User;
import com.todolist.spring.todolistt.core.domain.repository.GenericRepository;
import com.todolist.spring.todolistt.core.usecase.UserService;

public class UserServiceImpl implements UserService {

    private final GenericRepository<User, Long> userRepository;

    public UserServiceImpl(GenericRepository<User, Long> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        userRepository.save(user);
    }
    
}
