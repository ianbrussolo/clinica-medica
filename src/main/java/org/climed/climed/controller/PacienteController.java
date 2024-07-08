package org.climed.climed.controller;

import org.climed.climed.model.Paciente;
import org.climed.climed.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    public Paciente createAgenda(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}


