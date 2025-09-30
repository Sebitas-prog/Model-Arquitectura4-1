package com.FIIS.Arquitecturasem6.domain.reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    Reserva save(Reserva r);
    Optional<Reserva> findById(Long id);
    List<Reserva> findAll();
    void deleteById(Long id);
}
