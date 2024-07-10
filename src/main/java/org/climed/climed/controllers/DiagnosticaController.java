package org.climed.climed.controllers;

import org.climed.climed.model.Diagnostica;
import org.climed.climed.repository.DiagnosticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnostica")
public class DiagnosticaController {
    @Autowired
    private DiagnosticaRepository diagnosticaRepository;

    @GetMapping
    public List<Diagnostica> getAllDiagnostica() {
        return diagnosticaRepository.findAll();
    }

    @PostMapping
    public Diagnostica createDiagnostica(@RequestBody Diagnostica diagnostica) {
        return diagnosticaRepository.save(diagnostica);
    }
}
