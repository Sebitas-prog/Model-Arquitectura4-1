package com.FIIS.Arquitecturasem6.boot.web.reserva;

import com.FIIS.Arquitecturasem6.application.reserva.ConsultarReservasUseCase;
import com.FIIS.Arquitecturasem6.application.reserva.CrearReservaUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaWebController {

    private final ConsultarReservasUseCase consultar;
    private final CrearReservaUseCase crear;

    public ReservaWebController(ConsultarReservasUseCase consultar, CrearReservaUseCase crear) {
        this.consultar = consultar;
        this.crear = crear;
    }

    // GET /reservas -> muestra lista
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", consultar.listar());
        return "reservas"; // busca reservas.html en templates/
    }

    // GET /reservas/nueva -> muestra formulario
    @GetMapping("/nueva")
    public String nuevaForm() {
        return "nueva-reserva";
    }

    // POST /reservas -> guarda una reserva y redirige al listado
    @PostMapping
    public String crearReserva(ReservaForm form) {
        // Spring convierte automáticamente el campo fecha (yyyy-MM-dd'T'HH:mm) a LocalDateTime
        crear.handle(form.getRecurso(), form.getSolicitante(), form.getFecha());
        return "redirect:/reservas";
    }
}
