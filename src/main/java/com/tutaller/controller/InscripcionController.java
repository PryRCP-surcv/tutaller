package com.tutaller.controller;

import com.tutaller.model.Inscripcion;
import com.tutaller.service.InscripcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscripciones") // Ruta base para las inscripciones
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    // GET /api/inscripciones
    // Obtiene todas las inscripciones registradas
    @GetMapping
    public ResponseEntity<List<Inscripcion>> listarInscripciones() {
        return ResponseEntity.ok(inscripcionService.listarTodas());
    }

    // GET /api/inscripciones/{id}
    // Devuelve una inscripción específica por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> obtenerInscripcion(@PathVariable Long id) {
        Optional<Inscripcion> inscripcionOpt = inscripcionService.obtenerPorId(id);
        return inscripcionOpt.map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/inscripciones
    // Registra una nueva inscripción de un usuario a un taller
    @PostMapping
    public ResponseEntity<Inscripcion> crearInscripcion(@RequestBody Inscripcion inscripcion) {
        return ResponseEntity.ok(inscripcionService.guardar(inscripcion));
    }

    // PUT /api/inscripciones/{id}
    // Actualiza la inscripción existente (ej. cambiar estado o taller)
    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> actualizarInscripcion(@PathVariable Long id, @RequestBody Inscripcion actualizada) {
        Optional<Inscripcion> inscripcionOpt = inscripcionService.actualizar(id, actualizada);
        return inscripcionOpt.map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/inscripciones/{id}
    // Elimina una inscripción específica
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable Long id) {
        if (inscripcionService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
