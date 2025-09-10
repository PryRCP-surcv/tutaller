package com.tutaller.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutaller.model.Taller;
import com.tutaller.service.TallerService;

@RestController
@RequestMapping("/api/talleres") // Ruta base para talleres
public class TallerController {

    @Autowired
    private TallerService tallerService;

    // GET /api/talleres
    @GetMapping
    public ResponseEntity<List<Taller>> listarTalleres() {
        return ResponseEntity.ok(tallerService.listarTodos());
    }

    // GET /api/talleres/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Taller> obtenerTaller(@PathVariable Long id) {
        Optional<Taller> taller = tallerService.buscarPorId(id);
        return taller.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // POST /api/talleres
    @PostMapping
    public ResponseEntity<Taller> registrarTaller(@RequestBody Taller taller) {
        return ResponseEntity.ok(tallerService.registrar(taller));
    }

    // PUT /api/talleres/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Taller> actualizarTaller(@PathVariable Long id, @RequestBody Taller tallerActualizado) {
        Optional<Taller> tallerExistente = tallerService.buscarPorId(id);
        if (tallerExistente.isPresent()) {
            Taller taller = tallerExistente.get();
            taller.setNombre(tallerActualizado.getNombre());
            taller.setDescripcion(tallerActualizado.getDescripcion());
            taller.setDuracion(tallerActualizado.getDuracion());
            taller.setPrecio(tallerActualizado.getPrecio());
            taller.setImagen(tallerActualizado.getImagen());
            return ResponseEntity.ok(tallerService.registrar(taller));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/talleres/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTaller(@PathVariable Long id) {
        tallerService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
