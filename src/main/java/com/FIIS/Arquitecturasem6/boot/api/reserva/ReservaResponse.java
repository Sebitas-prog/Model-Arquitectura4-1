package com.FIIS.Arquitecturasem6.boot.api.reserva;

import java.time.LocalDateTime;

public class ReservaResponse {

    private Long id;
    private String recurso;
    private String solicitante;
    private LocalDateTime fecha;
    private String estado;

    public ReservaResponse(Long id, String recurso, String solicitante, LocalDateTime fecha, String estado) {
        this.id = id;
        this.recurso = recurso;
        this.solicitante = solicitante;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public String getRecurso() { return recurso; }
    public String getSolicitante() { return solicitante; }
    public LocalDateTime getFecha() { return fecha; }
    public String getEstado() { return estado; }
}
