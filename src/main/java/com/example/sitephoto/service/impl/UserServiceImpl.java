package com.example.sitephoto.service.impl;

import com.example.sitephoto.DTO.PhotoDTO;
import com.example.sitephoto.DTO.UserDTO;
import com.example.sitephoto.mapper.PhotoMapper;
import com.example.sitephoto.mapper.UserMapper;
import com.example.sitephoto.model.Photo;
import com.example.sitephoto.model.User;
import com.example.sitephoto.repository.PhotoRepository;
import com.example.sitephoto.repository.UserRepository;
import com.example.sitephoto.service.PhotoService;
import com.example.sitephoto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
    private final UserRepository userRepository;

//    @Autowired
    private final UserMapper userMapper;

//    @Autowired
    private final PhotoRepository photoRepository;

    private final PhotoMapper photoMapper;

//    PhotoService photoService = new PhotoServiceImpl(photoRepository);


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PhotoRepository photoRepository, PhotoMapper photoMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.photoRepository = photoRepository;
        this.photoMapper = photoMapper;
    }


    public List<UserDTO> findAll(){
        List<User> userList = (List<User>) userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (User user: userList){
            userDTOList.add(UserMapper.mapModelToDto(user));
        }
        return userDTOList;
    }

    @Override
    public Boolean login(String email, String password)
    {
        UserDTO user = this.findFirstByEmail(email);
        if(user.getPassword().equals(password))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
    @Override
    public UserDTO findFirstById (Long id){
        return UserMapper.mapModelToDto(userRepository.findFirstById(id));
    }

    @Override
    public UserDTO findFirstByName(String name){
        return UserMapper.mapModelToDto(userRepository.findFirstByName(name));
    }
    @Override
    public UserDTO findFirstByEmail(String email){
        return UserMapper.mapModelToDto(userRepository.findFirstByEmail(email));
    }
    @Override
    public void addUser(String name, String email, String password, Boolean admin, ArrayList<Photo> photoList) {
        User u = new User();
        u.setPassword(password);
        u.setName(name);
        u.setEmail(email);
        u.setAdmin(admin);
        u.setPhotoList(photoList);
        userRepository.save(u);
    }
    @Override
    public void addPhoto(User user, Photo photo) {
        User u = userRepository.findFirstById(user.getId());
        u.getPhotoList().add(photo);
        Photo p = photoRepository.findFirstById(photo.getId());
        p.setUser(user);
        photoRepository.save(p);
        userRepository.save(u);
    }
    @Override
    public void deletePhoto(User user, Photo photo) {
        User u = userRepository.findFirstById(user.getId());
        u.getPhotoList().remove(photo);
        userRepository.save(u);
        Photo p = photoRepository.findFirstById(photo.getId());
        p.setUser(null);
        photoRepository.delete(p);
    }
    public void deleteAllPhotos(User user) {
        user.setPhotoList(null);
    }
    @Override
    public void updateName(Long id, User newUser){
        User u = userRepository.findFirstById(id);// de implementat exceptie
        u.setName(newUser.getName());
        userRepository.save(u);
    }
    @Override
    public void updateEmail(Long id, User newUser){
        User u = userRepository.findFirstById(id);// de implementat exceptie
        u.setEmail(newUser.getEmail());
        userRepository.save(u);
    }
    @Override
    public void updatePassword(Long id, User newUser){
        User u = userRepository.findFirstById(id);// de implementat exceptie
        u.setPassword(newUser.getPassword());
        userRepository.save(u);
    }
    @Override
    public void updateAdmin(Long id){
        User u = userRepository.findFirstById(id);// de implementat exceptie
        if(u.getAdmin().equals(Boolean.TRUE)){
            u.setAdmin(Boolean.FALSE);
        }else{//toggle
            u.setAdmin(Boolean.TRUE);
        }
        userRepository.save(u);
    }


    @Override
    public void updatePhotoList(Long id, User newUser){
        User u = userRepository.findFirstById(id);// de implementat exceptie
        u.setPhotoList(newUser.getPhotoList());
        userRepository.save(u);
    }
    @Override
    public User updateUser(Long id, User newUser){
        User u = userRepository.findFirstById(id);// de implementat exceptie
        u.setName(newUser.getName());
        u.setEmail(newUser.getEmail());
        u.setPassword(newUser.getPassword());
        u.setAdmin(newUser.getAdmin());
        u.setPhotoList(newUser.getPhotoList());
        userRepository.save(u);
        return u;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteFirstByIdIfUserAdmin(User userAdmin, Long id){
        if(userAdmin.getAdmin()) {
            User u = userRepository.findFirstById(id);
            UserService userService= new UserServiceImpl(userRepository,userMapper,photoRepository,photoMapper);
            userService.deleteAllPhotos(u);
            userRepository.deleteById(id);
        }
    }
}
