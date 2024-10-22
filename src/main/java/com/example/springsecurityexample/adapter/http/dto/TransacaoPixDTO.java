package com.example.springsecurityexample.adapter.http.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransacaoPixDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigoTrancacao;

    private String codigoPessoa;

    private BigDecimal valorTrancacao;

    private Date dataTrancacao;

    private String codigoBeneficiario;

}
