package com.unoveo.userservices;

import com.unoveo.DTO.UserDTO;
import com.unoveo.entity.User;
import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDto);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();
}
