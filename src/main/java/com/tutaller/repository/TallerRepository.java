package com.tutaller.repository;

import com.tutaller.model.Taller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallerRepository extends JpaRepository<Taller, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas, por ejemplo:
    // List<Taller> findByNombreContainingIgnoreCase(String nombre);
}
