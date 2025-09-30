package com.FIIS.Arquitecturasem6.infrastructure.reserva;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReservaJpa extends JpaRepository<ReservaEntity, Long> {
}
