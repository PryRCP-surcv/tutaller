package com.tutaller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutaller.dto.UsuarioDTO;
import com.tutaller.model.Usuario;
import com.tutaller.repository.UsuarioRepository;
import com.tutaller.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Guarda un nuevo usuario (POST)
    @Override
    public Usuario guardar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombres(usuarioDTO.getNombres());
        usuario.setApellidos(usuarioDTO.getApellidos());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setContrasena(usuarioDTO.getContrasena()); // Idealmente, la contraseña debería encriptarse aquí
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setRol(usuarioDTO.getRol());
        return usuarioRepository.save(usuario);
    }

    // Lista todos los usuarios (GET)
    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Obtiene un usuario por ID (GET)
    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Actualiza un usuario existente (PUT)
    @Override
    public Optional<Usuario> actualizar(Long id, UsuarioDTO usuarioDTO) {
        return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setNombres(usuarioDTO.getNombres());
            usuarioExistente.setApellidos(usuarioDTO.getApellidos());
            usuarioExistente.setCorreo(usuarioDTO.getCorreo());
            usuarioExistente.setContrasena(usuarioDTO.getContrasena());
            usuarioExistente.setTelefono(usuarioDTO.getTelefono());
            usuarioExistente.setRol(usuarioDTO.getRol());
            return usuarioRepository.save(usuarioExistente);
        });
    }

    // Elimina un usuario por ID (DELETE)
    @Override
    public boolean eliminar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
