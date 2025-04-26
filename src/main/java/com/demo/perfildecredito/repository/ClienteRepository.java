package com.demo.perfildecredito.repository;

import com.demo.perfildecredito.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Exemplo: List<Cliente> findByNome(String nome);
}
