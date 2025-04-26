package com.demo.perfildecredito.service;

import com.demo.perfildecredito.model.IndicadorInadimplencia;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class IntegracaoInadimplenciaService {
    private static final String URL_INADIMPLENCIA =
            "https://api.bcb.gov.br/dados/serie/bcdata.sgs.13685/dados/ultimos/1?formato=json";

    public IndicadorInadimplencia consultarTaxaInadimplencia() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Map<String, String>>> response = restTemplate.exchange(
                URL_INADIMPLENCIA,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, String>>>() {}
        );
        Map<String, String> dados = response.getBody().get(0);
        BigDecimal valor = new BigDecimal(dados.get("valor").replace(",", "."));
        LocalDate data = LocalDate.parse(dados.get("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return new IndicadorInadimplencia(valor, data);
    }

}
