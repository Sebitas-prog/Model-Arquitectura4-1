package com.FIIS.Arquitecturasem6.application.reserva;

import com.FIIS.Arquitecturasem6.domain.reserva.Reserva;
import com.FIIS.Arquitecturasem6.domain.reserva.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultarReservasUseCase {

    private final ReservaRepository repository;

    public ConsultarReservasUseCase(ReservaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Reserva> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Reserva> porId(Long id) {
        return repository.findById(id);
    }
}
