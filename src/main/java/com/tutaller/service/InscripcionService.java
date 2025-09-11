package com.tutaller.service;

import java.util.List;
import java.util.Optional;

import com.tutaller.dto.InscripcionDTO;
import com.tutaller.model.Inscripcion;

public interface InscripcionService {
    Inscripcion guardar(InscripcionDTO inscripcionDTO); // POST

    // GET
    List<Inscripcion> listarTodas();

    // GET por id
    Optional<Inscripcion> obtenerPorId(Long id);

    Optional<Inscripcion> actualizar(Long id, InscripcionDTO inscripcionDTO); // PUT

    boolean eliminar(Long id);
}
