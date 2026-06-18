package com.todoautos.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todoautos.clientes.entity.Cliente;
import java.util.Optional; // <--- Importante añadir este import

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Añadimos este método para buscar por RUT
    Optional<Cliente> findByRutCliente(String rutCliente);
}