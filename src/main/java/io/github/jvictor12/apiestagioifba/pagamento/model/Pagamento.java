package io.github.jvictor12.apiestagioifba.pagamento.model;

import io.github.jvictor12.apiestagioifba.aquisicao.model.Aquisicao;
import io.github.jvictor12.apiestagioifba.empenho.model.Empenho;
import io.github.jvictor12.apiestagioifba.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "tb_pagamento")
public class Pagamento extends AbstractEntity {

    private LocalDate envioNf;

    @NotEmpty
    private String notaFiscal;

    private LocalDate dataNl;

    @NotEmpty
    private String numeroNl;

    private LocalDate dataOrdem;

    @NotEmpty
    private String numeroOrdem;

    @NotEmpty
    private String status;

    @ManyToOne
    @NotNull
    private Empenho empenho;

    @ManyToOne
    @NotNull
    private Aquisicao aquisicao;
}
