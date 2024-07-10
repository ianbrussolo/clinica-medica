package org.climed.climed.controllers;

import org.climed.climed.model.Diagnostico;
import org.climed.climed.repository.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @GetMapping
    public List<Diagnostico> getAllDiagnosticos() {
        return diagnosticoRepository.findAll();
    }

    @PostMapping
    public Diagnostico createDiagnostico(@RequestBody Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }
}

