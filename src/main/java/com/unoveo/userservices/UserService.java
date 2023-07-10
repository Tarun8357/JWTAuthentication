package com.unoveo.userservices;

import com.unoveo.DTO.UserDTO;
import com.unoveo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    void saveUser(UserDTO userDto);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();
}
