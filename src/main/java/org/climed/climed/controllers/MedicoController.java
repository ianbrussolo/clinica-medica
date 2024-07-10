package org.climed.climed.controllers;

import org.climed.climed.exception.ResourceNotFoundException;
import org.climed.climed.model.Medico;
import org.climed.climed.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    @GetMapping("/{crm}")
    public Medico getMedico(String crm) throws ResourceNotFoundException {
        return medicoRepository.findById(crm)
                .orElseThrow(() -> new ResourceNotFoundException("Medico not found with crm: " + crm));
    }

    @PostMapping
    public Medico createAgenda(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }
}

