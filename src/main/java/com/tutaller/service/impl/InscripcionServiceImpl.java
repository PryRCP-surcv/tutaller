package com.tutaller.service.impl;

import com.tutaller.dto.InscripcionDTO;
import com.tutaller.model.Inscripcion;
import com.tutaller.model.Taller;
import com.tutaller.model.Usuario;
import com.tutaller.repository.InscripcionRepository;
import com.tutaller.repository.TallerRepository;
import com.tutaller.repository.UsuarioRepository;
import com.tutaller.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository; // Inyectar
    @Autowired
    private TallerRepository tallerRepository; // Inyectar

    @Override
    public Inscripcion guardar(InscripcionDTO inscripcionDTO) {
        // Buscar las entidades a partir de los IDs
        Usuario usuario = usuarioRepository.findById(inscripcionDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Taller taller = tallerRepository.findById(inscripcionDTO.getTallerId())
                .orElseThrow(() -> new RuntimeException("Taller no encontrado"));

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setFechaInscripcion(inscripcionDTO.getFechaInscripcion());
        inscripcion.setEstado(inscripcionDTO.getEstado());
        inscripcion.setUsuario(usuario); // Asignar la entidad completa
        inscripcion.setTaller(taller); // Asignar la entidad completa

        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public List<Inscripcion> listarTodas() {
        return inscripcionRepository.findAll();
    }

    @Override
    public Optional<Inscripcion> obtenerPorId(Long id) {
        return inscripcionRepository.findById(id);
    }

    @Override
    public Optional<Inscripcion> actualizar(Long id, InscripcionDTO inscripcionDTO) {
        // 1. Buscar la inscripción existente que se quiere actualizar
        return inscripcionRepository.findById(id).map(inscripcionExistente -> {

            // 2. Buscar las nuevas entidades de Usuario y Taller a partir de los IDs del
            // DTO
            Usuario usuario = usuarioRepository.findById(inscripcionDTO.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            Taller taller = tallerRepository.findById(inscripcionDTO.getTallerId())
                    .orElseThrow(() -> new RuntimeException("Taller no encontrado"));

            // 3. Actualizar los campos de la inscripción existente
            inscripcionExistente.setFechaInscripcion(inscripcionDTO.getFechaInscripcion());
            inscripcionExistente.setEstado(inscripcionDTO.getEstado());
            inscripcionExistente.setUsuario(usuario);
            inscripcionExistente.setTaller(taller);

            // 4. Guardar y devolver la inscripción actualizada
            return inscripcionRepository.save(inscripcionExistente);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if (inscripcionRepository.existsById(id)) {
            inscripcionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
