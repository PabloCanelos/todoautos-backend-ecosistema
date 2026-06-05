package com.todoautos.usuarios.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // Crear nuevo permiso con estándar RESTful y manejo defensivo de errores
    @PostMapping("/crear") // Puedes mantener el "/crear" si así lo exige tu rúbrica, o dejarlo vacío si usas la URL base
    public ResponseEntity<?> createPermission(@RequestBody Permiso permission) {
        try {
            // Ejecutamos tu servicio blindado
            Permiso nuevoPermiso = permisoService.crearPermiso(permission);

            // ÉXITO: Retornamos el HTTP 201 Created con el objeto real
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPermiso);

        } catch (IllegalArgumentException e) {
            // ERROR DE CLIENTE: Formatos inválidos atrapados por tu DataValidator (HTTP 400 Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        } catch (RuntimeException e) {
            // ERROR DE NEGOCIO: Duplicidad en la base de datos MySQL (HTTP 409 Conflict)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (Exception e) {
            // ERROR DEL SERVIDOR: Cualquier fallo inesperado en la infraestructura (HTTP 500)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado en el servidor al procesar el registro.");
        }
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
