package org.climed.climed.controllers;

import org.climed.climed.exception.ResourceNotFoundException;
import org.climed.climed.model.*;
import org.climed.climed.repository.AgendaRepository;
import org.climed.climed.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/{id}")
    public Agenda getAgenda(@PathVariable int id) {
        return agendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agenda not found with id: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable Integer id, @RequestBody Agenda agendaDetails) {
        Optional<Agenda> optionalAgenda = agendaRepository.findById(id);
        if (!optionalAgenda.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Agenda agenda = optionalAgenda.get();

        Optional<Medico> medicoOptional = medicoRepository.findById(agendaDetails.getMedico().getCrm());
        if (!medicoOptional.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }
        agenda.setMedico(medicoOptional.get());

        agenda.setDiasemana(agendaDetails.getDiasemana());
        agenda.setHorainicio(agendaDetails.getHorainicio());
        agenda.setHorafim(agendaDetails.getHorafim());

        Agenda updatedAgenda = agendaRepository.save(agenda);
        return ResponseEntity.ok(updatedAgenda);
    }

    @GetMapping
    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    @PostMapping
    public Agenda createAgenda(@RequestBody Agenda agenda) {
        return agendaRepository.save(agenda);
    }
}
