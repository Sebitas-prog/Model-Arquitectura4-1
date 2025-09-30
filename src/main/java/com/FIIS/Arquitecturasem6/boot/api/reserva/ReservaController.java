package com.FIIS.Arquitecturasem6.boot.api.reserva;

import com.FIIS.Arquitecturasem6.application.reserva.ConsultarReservasUseCase;
import com.FIIS.Arquitecturasem6.application.reserva.CrearReservaUseCase;
import com.FIIS.Arquitecturasem6.application.reserva.EliminarReservaUseCase;
import com.FIIS.Arquitecturasem6.domain.reserva.Reserva;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
@Validated
public class ReservaController {

    private final CrearReservaUseCase crear;
    private final ConsultarReservasUseCase consultar;
    private final EliminarReservaUseCase eliminar;

    public ReservaController(CrearReservaUseCase crear,
                             ConsultarReservasUseCase consultar,
                             EliminarReservaUseCase eliminar) {
        this.crear = crear;
        this.consultar = consultar;
        this.eliminar = eliminar;
    }

    // POST /api/reservas
    @PostMapping
    public ResponseEntity<ReservaResponse> crear(@Valid @RequestBody ReservaRequest req) {
        Reserva r = crear.handle(req.getRecurso(), req.getSolicitante(), req.getFecha());
        ReservaResponse resp = toResponse(r);
        return ResponseEntity
                .created(URI.create("/api/reservas/" + resp.getId()))
                .body(resp);
    }

    // GET /api/reservas
    @GetMapping
    public List<ReservaResponse> listar() {
        return consultar.listar().stream().map(this::toResponse).toList();
    }

    // GET /api/reservas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> porId(@PathVariable Long id) {
        Optional<Reserva> r = consultar.porId(id);
        return r.map(value -> ResponseEntity.ok(toResponse(value)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // DELETE /api/reservas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        // opcional: validar existencia antes de borrar
        eliminar.handle(id);
        return ResponseEntity.noContent().build();
    }

    // --- Mapper simple de Dominio -> Response DTO ---
    private ReservaResponse toResponse(Reserva r) {
        return new ReservaResponse(
                r.getId(),
                r.getRecurso(),
                r.getSolicitante(),
                r.getFecha(),
                r.getEstado().name()
        );
    }
}
