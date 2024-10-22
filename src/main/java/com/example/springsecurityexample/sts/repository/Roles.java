package com.example.springsecurityexample.sts.repository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Entity
@Table(name = "roles")
@Accessors(chain = true)
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigoid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoid;

    @Column(name = "desc_role", nullable = false)
    private String descRole;

//    @ManyToMany(mappedBy = "roles")
//    private List<Users> users;
}
