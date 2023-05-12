package com.example.sitephoto;

import com.example.sitephoto.DTO.PhotoDTO;
import com.example.sitephoto.DTO.UserDTO;
import com.example.sitephoto.model.Photo;
import com.example.sitephoto.model.User;
import com.example.sitephoto.repository.PhotoRepository;
import com.example.sitephoto.repository.UserRepository;
import com.example.sitephoto.service.PhotoService;
import com.example.sitephoto.service.UserService;
import com.example.sitephoto.service.impl.PhotoServiceImpl;
import com.example.sitephoto.service.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@EntityScan
//@EnableJpaRepositories
@SpringBootApplication
public class SiteApplication {
    public SiteApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PhotoRepository photoRepository, UserRepository userRepository, PhotoService photoService, UserService userService) {
        return (args) -> {
//            PhotoServiceImpl photoService = new PhotoServiceImpl(photoRepository);
//            UserServiceImpl userService = new UserServiceImpl(userRepository);
//            User user1 = new User("User1", "Email1", "pass1", Boolean.TRUE,new LinkedList<Photo>());
//            Photo photo1 = new Photo("Photo1","B:\\Poze\\Poze Aparat edit\\Lightroom exports\\BOL_4929-16x9.jpg","First Photo",userService.findFirstByName("User1"));
//            photoRepository.save(photo1);

//            Field field = User.class.getDeclaredField("photoList");
//            field.setAccessible(true);

            userService.addUser("User1", "Email1", "pass1", Boolean.TRUE,new ArrayList<>());
            userService.addUser("User2", "Email2", "pass2", Boolean.FALSE,new ArrayList<>());
            UserDTO user1 = userService.findFirstByName("User1");
            UserDTO user2 = userService.findFirstByName("User2");
            photoService.addPhoto(user1.getId(), "Photo1","/assets/BOL_4929-16x9.jpg","First Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user1.getId(), "Photo3","/assets/BOL_8065-2.jpg","Third Photo",null);


            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);
            photoService.addPhoto(user2.getId(), "Photo2","/assets/BOL_7158.jpg","Second Photo",null);



//            userService.addPhoto(userRepository.findFirstByName("User1"),photoRepository.findFirstByName("Photo1"));
            PhotoDTO photo1 = photoService.findFirstByName("Photo1");
//            photoService.deleteFirstById(photo1.getId());
            //photoRepository.save(photoService.updatePhoto(photoRepository.findFirstByName("Photo3"),2L));

        };
    }

}
