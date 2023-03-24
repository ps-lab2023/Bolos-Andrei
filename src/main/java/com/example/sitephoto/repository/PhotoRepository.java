package com.example.sitephoto.repository;

import com.example.sitephoto.model.Photo;
import com.example.sitephoto.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {

    Photo findFirstById (Long id);
    Photo findFirstByName(String name);
    Photo findFirstByUser(User user);
    Photo findFirstByDescription(String description);
//    void addPhoto(String name,String path,String description,Boolean admin, User user);
//    Photo updatePhoto(Photo photo);
//    void deleteFirstById(Long id);
}
