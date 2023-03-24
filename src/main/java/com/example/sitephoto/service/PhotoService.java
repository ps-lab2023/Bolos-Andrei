package com.example.sitephoto.service;

import com.example.sitephoto.model.Photo;
import com.example.sitephoto.model.User;
import org.springframework.stereotype.Component;

//@Component
public interface PhotoService {
    Photo findFirstByName(String name);
    Photo findFirstById (Long id);
    Photo findFirstByUser(User user);
    Photo findFirstByDescription(String description);
    void addPhoto(String name,String path,String description,Boolean admin, User user);
    Photo updatePhoto(Photo photo,Long id);
    void deleteFirstById(Long id);
}
