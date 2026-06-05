package com.todoautos.compatibilidad.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.todoautos.compatibilidad.entity.Compatibilidad;
import com.todoautos.compatibilidad.repository.CompatibilidadRepository;

@Service
public class CompatibilidadService {
    @Autowired
    private CompatibilidadRepository compatibilidadRepository;
    @Autowired
    private RestTemplate restTemplate;
    // 1. LISTAR TODO
    public List<Compatibilidad> listarTodo() {
        List<Compatibilidad> lista = compatibilidadRepository.findAll();
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("ERROR: N se puede recuperar la lista o lista no existe ");
        }
        return lista;
    }

    // 2. BUSCAR POR ID
    public Compatibilidad buscarPorId(Integer id) {
        if(id == null){
            throw new RuntimeException("ERROR: El ID no existe, vuelve a intentarlo");
        }
        if(id<=0){
            throw new RuntimeException("ERROR: ID no es valido.  El id no puede ser menor a 1");
        }
        return compatibilidadRepository.findById(id).
            orElseThrow(()-> new RuntimeException("ERROR: La compatibilidad con id("+ id+" no se encuentra en la base de datos"));
    }

    /**
     * Registra la compatibilidad verificando primero la existencia del repuesto
     * en el Microservicio de Catálogo.
     */
    public Compatibilidad registrarCompatibilidad(Compatibilidad compatibilidad) {
        // Se asume que el MS Catálogo tiene un endpoint que retorna Boolean si el ID existe
        String url = "http://localhost:8081/repuestos/existe/" + compatibilidad.getRepuestoId();

        try {
            Boolean existe = restTemplate.getForObject(url, Boolean.class);

            if (Boolean.TRUE.equals(existe)) {
                return compatibilidadRepository.save(compatibilidad);
            } else {
                throw new RuntimeException("El repuesto ID " + compatibilidad.getRepuestoId() + " no existe en el catálogo[cite: 8].");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error de comunicación con el MS Catálogo: " + e.getMessage());
        }
    }

    // 4. ACTUALIZAR
    public Compatibilidad actualizarCompatibilidad(Compatibilidad c) {
        // A.Validamos que la compatibilidad exista antes de intentar guardar
        if (c.getIdCompatibilidad() != null || c.getIdCompatibilidad()<=0) {
            throw new RuntimeException("ERROR: Debe proporcionar un ID de compatibilidad valido para actualizar");
        }
        // B. Validación de existencia
        // C. Validación de Lógica de Negocio (Fechas y campos obligatorios)
        if (c.getAnnioInicio() == null || c.getAnnioTermino() == null) {
            throw new RuntimeException("Error: Los campos de año de inicio y término son obligatorios.");
        }

        if (c.getAnnioInicio() > c.getAnnioTermino()) {
            throw new RuntimeException("Error: El año de inicio (" + c.getAnnioInicio() + ") no puede ser mayor al de término (" + c.getAnnioTermino() + ").");
        }

        if (c.getObservaciones() == null || c.getObservaciones().trim().isEmpty()) {
             throw new RuntimeException("Error: Las observaciones no pueden estar vacías.");
        }

        // D. Verificación de ID de Repuesto
        if (c.getRepuestoId() == null || c.getRepuestoId() <= 0) {
            throw new RuntimeException("Error: El ID de repuesto vinculado no es válido.");
        }

        // Si pasa todas las pruebas, guardamos
        return compatibilidadRepository.save(c);
    }

    // 5. ELIMINAR CON VALIDACIÓN DE EXISTENCIA
    public void eliminarCompatibilidad(Integer id) {

        // A. Validación de entrada (No nulo y positivo)
        if (id == null || id <= 0) {
            throw new RuntimeException("Error: El ID proporcionado no es válido para la eliminación.");
        }

        // B. Validación de presencia en la Base de Datos
        // Es vital verificar antes de borrar para manejar el error de forma limpia
        if (!compatibilidadRepository.existsById(id)) {
            throw new RuntimeException("Error: No se puede eliminar. La compatibilidad con ID " + id + " no existe en el sistema.");
        }

        try {
            // C. Ejecución del borrado
            compatibilidadRepository.deleteById(id);
        } catch (Exception e) {
            // D. Captura de errores de integridad referencial
            // Por ejemplo, si intentas borrar algo que está siendo usado por otro proceso
            throw new RuntimeException("Error: No se pudo eliminar el registro debido a un conflicto de integridad.");
        }
    }

    //metodo para comunicar con rest template. con el mciro servicio repuesto
    public Compatibilidad compatibilidad(Compatibilidad c){
        String url = "http://localhost:8081/repuestos/id/" + c.getRepuestoId();
        Boolean existe = restTemplate.getForObject(url, Boolean.class);
        if(Boolean.TRUE.equals(existe)){
            return compatibilidadRepository.save(c);
        }else{
            throw new RuntimeException("El repuesto ID" + c.getRepuestoId() + "no existe en el catalogo");
        }
    }

}
