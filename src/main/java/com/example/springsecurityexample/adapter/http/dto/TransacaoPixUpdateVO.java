package com.example.springsecurityexample.adapter.http.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class TransacaoPixUpdateVO extends TransacaoPixVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
