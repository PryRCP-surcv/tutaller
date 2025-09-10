package com.tutaller.service.impl;

import com.tutaller.model.Inscripcion;
import com.tutaller.repository.InscripcionRepository;
import com.tutaller.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Override
    public Inscripcion guardar(Inscripcion inscripcion) {
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
    public Optional<Inscripcion> actualizar(Long id, Inscripcion inscripcionActualizada) {
        return inscripcionRepository.findById(id).map(inscripcionExistente -> {
            inscripcionExistente.setTaller(inscripcionActualizada.getTaller());
            inscripcionExistente.setUsuario(inscripcionActualizada.getUsuario());
            // otros campos como fecha, estado, etc.
            return Optional.of(inscripcionRepository.save(inscripcionExistente));
        }).orElse(Optional.empty());
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
