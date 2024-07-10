package org.climed.climed.controllers;

import org.climed.climed.model.Especialidade;
import org.climed.climed.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @GetMapping
    public List<Especialidade> getAllEspecialidades() {
        return especialidadeRepository.findAll();
    }

    @PostMapping
    public Especialidade createAgenda(@RequestBody Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }
}

