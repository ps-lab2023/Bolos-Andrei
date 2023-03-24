package com.example.sitephoto;

import com.example.sitephoto.model.Photo;
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
            userService.addUser("User1", "Email1", "pass1", Boolean.TRUE);
            userService.addUser("User2", "Email2", "pass2", Boolean.FALSE);
            photoService.addPhoto("Photo1","B:\\Poze\\Poze Aparat edit\\Lightroom exports\\BOL_4929-16x9.jpg","First Photo",userService.findFirstByName("User1").getAdmin(),userService.findFirstByName("User1"));
            photoService.addPhoto("Photo2","B:\\Poze\\Poze Aparat edit\\Lightroom exports","Second Photo",userService.findFirstByName("User2").getAdmin(),userService.findFirstByName("User2"));
            photoService.addPhoto("Photo3","B:\\Poze\\g","Third Photo",userService.findFirstByName("User2").getAdmin(),userService.findFirstByName("User2"));

//            Photo x = new Photo();
//            photoRepository.save(x);

            photoRepository.save(photoService.updatePhoto(photoService.findFirstByName("Photo3"),2L));

        };
    }

}
