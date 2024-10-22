package com.example.springsecurityexample.adapter.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "transacao_pix")
public class TransacaoPix implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codigo_trancacao", nullable = false)
    private String codigoTrancacao;

    @Column(name = "codigo_pessoa", nullable = false)
    private String codigoPessoa;

    @Column(name = "valor_trancacao", nullable = false)
    private BigDecimal valorTrancacao;

    @Column(name = "data_trancacao")
    private Date dataTrancacao;

    @Column(name = "codigo_beneficiario")
    private String codigoBeneficiario;

}
