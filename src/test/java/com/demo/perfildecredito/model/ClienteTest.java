package com.demo.perfildecredito.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    void testCriacaoCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João Silva");
        cliente.setCpf("12345678901");
        cliente.setRendaMensal(new BigDecimal("8500.00"));
        cliente.setDividaAtual(new BigDecimal("1500.00"));
        cliente.setTaxaInadimplenciaAtual(new BigDecimal("0.0395"));
        cliente.setDataConsultaInadimplencia(LocalDate.of(2025, 4, 24));

        assertEquals(1L, cliente.getId());
        assertEquals("João Silva", cliente.getNome());
        assertEquals("12345678901", cliente.getCpf());
        assertEquals(new BigDecimal("8500.00"), cliente.getRendaMensal());
        assertEquals(new BigDecimal("1500.00"), cliente.getDividaAtual());
        assertEquals(new BigDecimal("0.0395"), cliente.getTaxaInadimplenciaAtual());
        assertEquals(LocalDate.of(2025, 4, 24), cliente.getDataConsultaInadimplencia());
    }
}
