package com.example.sitephoto.service.impl;

import com.example.sitephoto.model.Photo;
import com.example.sitephoto.model.User;
import com.example.sitephoto.repository.UserRepository;
import com.example.sitephoto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findFirstById (Long id){
        return userRepository.findFirstById(id);
    }

    @Override
    public User findFirstByName(String name){
        return userRepository.findFirstByName(name);
    }

    @Override
    public User findFirstByEmail(String email){
        return userRepository.findFirstByEmail(email);
    }

    @Override
    public void addUser(String name,String email,String password,Boolean admin)
    {
        User u = new User();
        u.setPassword(password);
        u.setName(name);
        u.setEmail(email);
        u.setAdmin(admin);
        userRepository.save(u);
    }
    @Override
    public User updateUser(User user,Long id){
        User u = userRepository.findFirstById(id);// de implementat exceptie
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAdmin(user.getAdmin());

        userRepository.save(u);
        return u;
    }

    @Override
    public void deleteFirstById(Long id, User user)
    {
        if(user.getAdmin()) {
            User u = userRepository.findFirstById(id);
            if(u.getPhotoList()!= null)
                for (Photo photo : u.getPhotoList()) {
                    deleteFirstById(photo.getId(), user);
                }
            userRepository.delete(u);
        }
    }
}
