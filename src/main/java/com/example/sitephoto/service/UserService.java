package com.example.sitephoto.service;

import com.example.sitephoto.model.Photo;
import com.example.sitephoto.model.User;
import com.example.sitephoto.repository.UserRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

//@Component
public interface UserService {
    User findFirstById(Long id);
    User findFirstByName(String name);
    User findFirstByEmail(String email);
    User updateUser(User user, Long id);
    void addUser(String name,String email,String password,Boolean admin);
    void deleteFirstById(Long id,User user);
}
