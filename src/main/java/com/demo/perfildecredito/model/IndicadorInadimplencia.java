package com.demo.perfildecredito.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class IndicadorInadimplencia {

    private BigDecimal valor;       // Ex: 0.0395 (3,95%)
    private LocalDate dataConsulta; // Data da consulta

    public IndicadorInadimplencia(BigDecimal valor, LocalDate dataConsulta) {
        this.valor = valor;
        this.dataConsulta = dataConsulta;
    }

}
