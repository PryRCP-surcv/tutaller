package com.tutaller.service;

import java.util.List;
import java.util.Optional;
import com.tutaller.model.Usuario;
import com.tutaller.dto.UsuarioDTO; // Importar

public interface UsuarioService {
    Usuario guardar(UsuarioDTO usuarioDTO); // Modificar para usar DTO

    Optional<Usuario> actualizar(Long id, UsuarioDTO usuarioDTO); // Modificar para usar DTO

    List<Usuario> listarTodos();

    Optional<Usuario> obtenerPorId(Long id);

    boolean eliminar(Long id);
}