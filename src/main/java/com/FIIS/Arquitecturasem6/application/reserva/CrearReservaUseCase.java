package com.FIIS.Arquitecturasem6.application.reserva;

import com.FIIS.Arquitecturasem6.domain.reserva.Reserva;
import com.FIIS.Arquitecturasem6.domain.reserva.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class CrearReservaUseCase {

    private final ReservaRepository repository;

    public CrearReservaUseCase(ReservaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Reserva handle(String recurso, String solicitante, LocalDateTime fecha) {
        // Validaciones simples de aplicación (puedes endurecerlas si deseas)
        Objects.requireNonNull(recurso, "recurso es obligatorio");
        Objects.requireNonNull(solicitante, "solicitante es obligatorio");
        Objects.requireNonNull(fecha, "fecha es obligatoria");

        if (recurso.isBlank()) throw new IllegalArgumentException("recurso no puede estar vacío");
        if (solicitante.isBlank()) throw new IllegalArgumentException("solicitante no puede estar vacío");

        Reserva nueva = new Reserva(
                null,
                recurso.trim(),
                solicitante.trim(),
                fecha,
                Reserva.Estado.PENDIENTE
        );
        return repository.save(nueva);
    }
}
