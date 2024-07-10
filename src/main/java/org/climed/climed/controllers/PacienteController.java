package org.climed.climed.controllers;

import org.climed.climed.exception.ResourceNotFoundException;
import org.climed.climed.model.Medico;
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

    @GetMapping("/{cpf}")
    public Paciente getPaciente(String cpf) throws ResourceNotFoundException {
        return pacienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente not found with cpf: " + cpf));
    }

    @PostMapping
    public Paciente createAgenda(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}


