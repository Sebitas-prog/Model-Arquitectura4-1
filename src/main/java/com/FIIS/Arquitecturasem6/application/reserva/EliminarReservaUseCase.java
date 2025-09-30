package com.FIIS.Arquitecturasem6.application.reserva;

import com.FIIS.Arquitecturasem6.domain.reserva.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EliminarReservaUseCase {

    private final ReservaRepository repository;

    public EliminarReservaUseCase(ReservaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void handle(Long id) {
        repository.deleteById(id);
    }
}
