package org.climed.climed.controller;

import org.climed.climed.model.Agenda;
import org.climed.climed.model.Doenca;
import org.climed.climed.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
public class AgendaController {
    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping
    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    @PostMapping
    public Agenda createAgenda(@RequestBody Agenda agenda) {
        return agendaRepository.save(agenda);
    }
}
