package com.todolist.spring.todolistt.core.usecase;

import com.todolist.spring.todolistt.core.domain.dto.UserDTO;

public interface UserService {
    void saveUser(UserDTO userDTO   );
}
