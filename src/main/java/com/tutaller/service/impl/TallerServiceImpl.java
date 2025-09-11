package com.tutaller.service.impl;

import com.tutaller.dto.TallerDTO;
import com.tutaller.model.Taller;
import com.tutaller.repository.TallerRepository;
import com.tutaller.service.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TallerServiceImpl implements TallerService {

    @Autowired
    private TallerRepository tallerRepository;

    @Override
    public Taller registrar(TallerDTO tallerDTO) {
        Taller taller = new Taller();
        taller.setNombre(tallerDTO.getNombre());
        taller.setDescripcion(tallerDTO.getDescripcion());
        taller.setDuracion(tallerDTO.getDuracion());
        taller.setPrecio(tallerDTO.getPrecio());
        taller.setImagen(tallerDTO.getImagen());
        return tallerRepository.save(taller);
    }

    @Override
    public Optional<Taller> actualizar(Long id, TallerDTO tallerDTO) {
        return tallerRepository.findById(id).map(tallerExistente -> {
            tallerExistente.setNombre(tallerDTO.getNombre());
            tallerExistente.setDescripcion(tallerDTO.getDescripcion());
            tallerExistente.setDuracion(tallerDTO.getDuracion());
            tallerExistente.setPrecio(tallerDTO.getPrecio());
            tallerExistente.setImagen(tallerDTO.getImagen());
            return tallerRepository.save(tallerExistente);
        });
    }

    @Override
    public List<Taller> listarTodos() {
        return tallerRepository.findAll();
    }

    @Override
    public Optional<Taller> buscarPorId(Long id) {
        return tallerRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        tallerRepository.deleteById(id);
    }
}
