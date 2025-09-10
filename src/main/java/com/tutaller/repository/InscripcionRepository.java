package com.tutaller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutaller.model.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Ejemplo de métodos personalizados (opcionales, por si luego necesitas)
    
    // Listar inscripciones por ID de usuario
    List<Inscripcion> findByUsuarioId(Long usuarioId);

    // Listar inscripciones por ID de taller
    List<Inscripcion> findByTallerId(Long tallerId);

    // Verificar si ya existe una inscripción de un usuario a un taller (para evitar duplicados)
    boolean existsByUsuarioIdAndTallerId(Long usuarioId, Long tallerId);
}
