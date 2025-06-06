package com.api.apicliente.repository;

import com.api.apicliente.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
