package com.example.sitephoto.mapper;

import com.example.sitephoto.DTO.UserDTO;
import com.example.sitephoto.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDTO mapModelToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setAdmin(user.getAdmin());
//        userDTO.setPhotoList(user.getPhotoList());
        //userDTO.setOrdersList(user.getOrdersList());
        return userDTO;
    }
}
