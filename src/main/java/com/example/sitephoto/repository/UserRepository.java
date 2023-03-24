package com.example.sitephoto.repository;

import com.example.sitephoto.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findFirstById(Long id);
    User findFirstByName(String name);
    User findFirstByEmail(String email);
//    void addUser(String name,String path,String description,Boolean admin,User user);
//    User updateUser(User user);
//    void deleteFirstById(Long id,User user);
}
