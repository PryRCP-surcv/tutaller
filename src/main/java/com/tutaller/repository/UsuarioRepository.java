package com.tutaller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutaller.model.Usuario;

// Interfaz que extiende JpaRepository y maneja operaciones CRUD automáticamente
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aquí podrías agregar métodos personalizados si los necesitas, por ejemplo:
    // Optional<Usuario> findByEmail(String email);
}
