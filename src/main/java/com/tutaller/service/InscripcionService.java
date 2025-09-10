package com.tutaller.service;

import java.util.List;
import java.util.Optional;

import com.tutaller.model.Inscripcion;

public interface InscripcionService {
    Inscripcion guardar(Inscripcion inscripcion); // POST

    List<Inscripcion> listarTodas(); // GET

    Optional<Inscripcion> obtenerPorId(Long id); // GET por id

    Optional<Inscripcion> actualizar(Long id, Inscripcion inscripcionActualizada); // PUT

    boolean eliminar(Long id); // DELETE
}
