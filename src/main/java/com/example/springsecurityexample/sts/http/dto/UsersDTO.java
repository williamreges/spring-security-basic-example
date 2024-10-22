package com.example.springsecurityexample.sts.http.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "codigoid can not null")
    private Long codigoid;

    @NotNull(message = "codIdefPessoa can not null")
    private String codIdefPessoa;

    private String userName;

    private String password;

    private List<RolesDTO> roles;

}
