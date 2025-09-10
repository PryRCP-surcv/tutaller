package com.tutaller.service;

import java.util.List;
import java.util.Optional;

import com.tutaller.model.Taller;

public interface TallerService {
    Taller registrar(Taller taller); // POST

    List<Taller> listarTodos(); // GET

    Optional<Taller> buscarPorId(Long id); // GET por id

    void eliminar(Long id); // DELETE
}
