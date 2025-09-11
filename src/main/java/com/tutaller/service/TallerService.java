package com.tutaller.service;

import java.util.List;
import java.util.Optional;
import com.tutaller.model.Taller;
import com.tutaller.dto.TallerDTO; // Importar DTO

public interface TallerService {
    Taller registrar(TallerDTO tallerDTO); // POST - Modificado para usar DTO

    Optional<Taller> actualizar(Long id, TallerDTO tallerDTO); // PUT - Modificado para usar DTO

    List<Taller> listarTodos();

    Optional<Taller> buscarPorId(Long id);

    void eliminar(Long id);
}