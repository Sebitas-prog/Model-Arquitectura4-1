package com.FIIS.Arquitecturasem6.domain.reserva;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {
    private final Long id;                 // puede ser null al crear
    private final String recurso;
    private final String solicitante;
    private final LocalDateTime fecha;
    private final Estado estado;

    public enum Estado { PENDIENTE, APROBADA, RECHAZADA }

    public Reserva(Long id, String recurso, String solicitante, LocalDateTime fecha, Estado estado) {
        this.id = id;
        this.recurso = Objects.requireNonNull(recurso, "recurso es obligatorio");
        this.solicitante = Objects.requireNonNull(solicitante, "solicitante es obligatorio");
        this.fecha = Objects.requireNonNull(fecha, "fecha es obligatoria");
        this.estado = Objects.requireNonNull(estado, "estado es obligatorio");
    }

    public Long getId() { return id; }
    public String getRecurso() { return recurso; }
    public String getSolicitante() { return solicitante; }
    public LocalDateTime getFecha() { return fecha; }
    public Estado getEstado() { return estado; }

    // Reglas simples de dominio (ejemplos)
    public Reserva aprobar()   { return new Reserva(id, recurso, solicitante, fecha, Estado.APROBADA); }
    public Reserva rechazar()  { return new Reserva(id, recurso, solicitante, fecha, Estado.RECHAZADA); }
}
