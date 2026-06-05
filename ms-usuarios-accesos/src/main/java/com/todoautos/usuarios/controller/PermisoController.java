package com.todoautos.usuarios.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todoautos.usuarios.entity.Permiso;
import com.todoautos.usuarios.service.PermisoService;

@RestController
@RequestMapping("api/permisos")
public class PermisoController {
    @Autowired
    private PermisoService permisoService;

    // Crear nuevo permiso
    @PostMapping("/crear")
    public Permiso crearPermiso(@RequestBody Permiso permiso) {
        return permisoService.crearPermiso(permiso);
    }

    // Actualizar permiso existente
    @PutMapping("/actualizar")
    public Permiso actualizarPermiso(@RequestBody Permiso permiso) {
        return permisoService.crearPermiso(permiso);
    }

    // Listar todos
    @GetMapping("/listar")
    public List<Permiso> listar() {
        return permisoService.listarPermisos();
    }

    // Buscar uno solo
    @GetMapping("/buscar{id}")
    public Permiso buscar(@PathVariable Integer id) {
        return permisoService.buscarPorId(id);
    }

    // Eliminar
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        permisoService.eliminarPermiso(id);
    }

}
