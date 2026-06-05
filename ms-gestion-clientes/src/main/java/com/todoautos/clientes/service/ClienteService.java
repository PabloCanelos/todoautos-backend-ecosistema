package com.todoautos.clientes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todoautos.clientes.entity.Cliente;
import com.todoautos.clientes.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // 1. GUARDAR
    public Cliente guardarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new RuntimeException("Error: El objeto cliente no puede ser nulo.");
        }
        if (cliente.getRutCliente() == null || cliente.getRutCliente().trim().isEmpty()) {
            throw new RuntimeException("Error: El RUT del cliente es obligatorio.");
        }
        if (cliente.getPrimerNombreCliente() == null || cliente.getPrimerNombreCliente().trim().isEmpty()) {
            throw new RuntimeException("Error: El primer nombre del cliente es obligatorio.");
        }
        return clienteRepository.save(cliente);
    }

    // 2. LISTAR
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // 3. BUSCAR POR ID
    public Cliente buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID ingresado no es válido.");
        }
        return clienteRepository.findById(id).orElse(null);
    }

    // 4. ACTUALIZAR
    public Cliente actualizarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new RuntimeException("Error: El objeto cliente no puede ser nulo.");
        }
        if (cliente.getIdCliente() == null || cliente.getIdCliente() <= 0) {
            throw new RuntimeException("Error: Para actualizar, se requiere un ID de cliente válido.");
        }
        // Protección obligatoria: si el ID no existe en la BD, frena la operación
        // if (!clienteRepository.existsById(cliente.getIdCliente())) {
        //     throw new RuntimeException("Error: No se puede actualizar. El cliente con ID " + cliente.getIdCliente() + " no existe.");
        // }

        return clienteRepository.save(cliente);
    }

    // 5. ELIMINAR
    public void eliminarCliente(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID para eliminar no es válido.");
        }
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Error: No se puede eliminar, el cliente con ID " + id + " no existe.");
        }
        clienteRepository.deleteById(id);
    }
}