package com.example.springsecurityexample.sts.http.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class RolesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long codigoid;

    private String descRole;

}
