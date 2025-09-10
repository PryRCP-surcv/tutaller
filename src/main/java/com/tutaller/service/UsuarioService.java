package com.tutaller.service;

import java.util.List;
import java.util.Optional;

import com.tutaller.model.Usuario;

public interface UsuarioService {
    Usuario guardar(Usuario usuario); // POST
    List<Usuario> listarTodos(); // GET 
    Optional<Usuario> obtenerPorId(Long id); // GET por id
    Optional<Usuario> actualizar(Long id, Usuario usuarioActualizado); // PUT
    boolean eliminar(Long id); // DELETE
}
