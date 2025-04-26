package com.demo.perfildecredito.Controller;

import com.demo.perfildecredito.model.Cliente;
import com.demo.perfildecredito.model.IndicadorInadimplencia;
import com.demo.perfildecredito.repository.ClienteRepository;
import com.demo.perfildecredito.service.IntegracaoInadimplenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private IntegracaoInadimplenciaService inadimplenciaService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        IndicadorInadimplencia indicador = inadimplenciaService.consultarTaxaInadimplencia();
        cliente.setTaxaInadimplenciaAtual(indicador.getValor());
        cliente.setDataConsultaInadimplencia(indicador.getDataConsulta());
        return ResponseEntity.ok(repository.save(cliente));
    }
}
