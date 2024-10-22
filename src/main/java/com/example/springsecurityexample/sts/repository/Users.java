package com.example.springsecurityexample.sts.repository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigoid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoid;

    @Column(name = "cod_idef_pessoa", nullable = false)
    private String codIdefPessoa;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "codigoid_user"),
    inverseJoinColumns = @JoinColumn(name = "codigoid_role"))
    private List<Roles> roles;

}
