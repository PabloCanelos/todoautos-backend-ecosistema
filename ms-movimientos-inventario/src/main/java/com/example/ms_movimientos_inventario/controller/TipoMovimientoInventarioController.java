package com.example.ms_movimientos_inventario.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ms_movimientos_inventario.model.TipoMovimientoInventario;
import com.example.ms_movimientos_inventario.service.TipoMovimientoInventarioService;

@RestController
@RequestMapping("/api/tipos-movimientos")
public class TipoMovimientoInventarioController {
    @Autowired
    private TipoMovimientoInventarioService tipoMovimientoInventarioService;

    @PostMapping("/guardar")
    public TipoMovimientoInventario guardar(@RequestBody TipoMovimientoInventario tipoMovimiento){
        return tipoMovimientoInventarioService.guardarTipoMovimiento(tipoMovimiento);
    }

    @GetMapping("/listar")
    public List<TipoMovimientoInventario> listar(){
        return tipoMovimientoInventarioService.listarTodo();
    }

    @GetMapping("/buscar")
    public TipoMovimientoInventario buscar(@PathVariable Integer id){
        return tipoMovimientoInventarioService.buscarPorId(id);
    }

    @DeleteMapping("/eliminar/1{id}")
    public void eliminar(@PathVariable Integer id){
        tipoMovimientoInventarioService.eliminarTipoMovimiento(id);
    }



}
