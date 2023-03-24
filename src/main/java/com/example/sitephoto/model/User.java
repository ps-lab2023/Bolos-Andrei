package com.example.sitephoto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean admin;
//    private String telephone; // 07beaLapte

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "id")
    private List<Photo> photoList;

}
