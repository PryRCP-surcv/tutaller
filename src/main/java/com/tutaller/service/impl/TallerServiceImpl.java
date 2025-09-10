package com.tutaller.service.impl;

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
    public Taller registrar(Taller taller) {
        return tallerRepository.save(taller);
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
