package com.example.sitephoto.service.impl;

import com.example.sitephoto.model.Photo;
import com.example.sitephoto.model.User;
import com.example.sitephoto.repository.PhotoRepository;
import com.example.sitephoto.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo findFirstById(Long id) {
        return photoRepository.findFirstById(id);
    }

    @Override
    public Photo findFirstByName(String name) {
        return photoRepository.findFirstByName(name);
    }

    @Override
    public Photo findFirstByUser(User user) {
        return photoRepository.findFirstByUser(user);
    }

    @Override
    public Photo findFirstByDescription(String description) {
        return photoRepository.findFirstByDescription(description);
    }

    @Override
    public void addPhoto(String name, String path, String description, Boolean admin, User user) {
        Photo x = new Photo();
        x.setName(name);
        x.setPath(path);
        x.setDescription(description);
        photoRepository.save(x);
    }

    @Override
    public Photo updatePhoto(Photo photo,Long id) {
        Photo updatePhoto = photoRepository.findFirstById(id);// de implementat exceptie
        updatePhoto.setUser(photo.getUser());
        updatePhoto.setName(photo.getPath());
        updatePhoto.setDescription(photo.getDescription());
        photoRepository.save(updatePhoto);
        return updatePhoto;
    }

    public void deleteFirstById(Long id) {
        Photo p = photoRepository.findFirstById(id);
//        deleteFirstById(id);
        photoRepository.delete(p);

    }
}
