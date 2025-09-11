package com.tutaller.dto;

import java.time.LocalDate;

public class InscripcionDTO {

    private LocalDate fechaInscripcion;
    private String estado;
    private Long usuarioId; // Solo necesitamos el ID del usuario
    private Long tallerId; // Solo necesitamos el ID del taller

    // --- Getters y Setters ---

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getTallerId() {
        return tallerId;
    }

    public void setTallerId(Long tallerId) {
        this.tallerId = tallerId;
    }
}