package com.FIIS.Arquitecturasem6.infrastructure.reserva;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recurso;
    private String solicitante;
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado { PENDIENTE, APROBADA, RECHAZADA }

    // --- Getters y Setters (requeridos por JPA) ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRecurso() { return recurso; }
    public void setRecurso(String recurso) { this.recurso = recurso; }

    public String getSolicitante() { return solicitante; }
    public void setSolicitante(String solicitante) { this.solicitante = solicitante; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}
