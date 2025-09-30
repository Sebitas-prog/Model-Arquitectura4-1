package com.FIIS.Arquitecturasem6.infrastructure.reserva;

import com.FIIS.Arquitecturasem6.domain.reserva.Reserva;
import com.FIIS.Arquitecturasem6.domain.reserva.ReservaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.FIIS.Arquitecturasem6.infrastructure.reserva.ReservaMapper.*;

@Repository
public class ReservaRepositoryAdapter implements ReservaRepository {

    private final SpringDataReservaJpa jpa;

    public ReservaRepositoryAdapter(SpringDataReservaJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Reserva save(Reserva r) {
        return toDomain(jpa.save(toEntity(r)));
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return jpa.findById(id).map(ReservaMapper::toDomain);
    }

    @Override
    public List<Reserva> findAll() {
        return jpa.findAll().stream().map(ReservaMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
