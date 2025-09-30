package com.FIIS.Arquitecturasem6.infrastructure.reserva;

import com.FIIS.Arquitecturasem6.domain.reserva.Reserva;

public class ReservaMapper {

    public static ReservaEntity toEntity(Reserva d) {
        ReservaEntity e = new ReservaEntity();
        e.setId(d.getId());
        e.setRecurso(d.getRecurso());
        e.setSolicitante(d.getSolicitante());
        e.setFecha(d.getFecha());
        e.setEstado(ReservaEntity.Estado.valueOf(d.getEstado().name()));
        return e;
    }

    public static Reserva toDomain(ReservaEntity e) {
        return new Reserva(
                e.getId(),
                e.getRecurso(),
                e.getSolicitante(),
                e.getFecha(),
                Reserva.Estado.valueOf(e.getEstado().name())
        );
    }
}
