package io.github.jvictor12.apiestagioifba.pagamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.github.jvictor12.apiestagioifba.empenho.model.Empenho;
import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "tb_pagamento")
public class Pagamento extends AbstractEntity {

    private String envioNf;

    private String notaFiscal;

    private String dataNl;

    private String numeroNl;

    private String dataOrdem;

    @OneToOne
    @JsonBackReference
    private Empenho empenho;

    private String numeroOrdem;

    private String status;

}
