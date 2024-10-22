package com.example.springsecurityexample.adapter.http.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class TransacaoPixVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "codigoTrancacao can not null")
    private String codigoTrancacao;

    @NotNull(message = "codigoPessoa can not null")
    private String codigoPessoa;

    @NotNull(message = "valorTrancacao can not null")
    private BigDecimal valorTrancacao;

    private Date dataTrancacao;

    private String codigoBeneficiario;

}
