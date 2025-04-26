package com.demo.perfildecredito.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private BigDecimal rendaMensal;
    private BigDecimal dividaAtual;

    // Taxa de inadimplência vigente no momento do cadastro/análise
    private BigDecimal taxaInadimplenciaAtual;

    // Data em que a taxa foi consultada
    private LocalDate dataConsultaInadimplencia;

    // Getters e setters
}
