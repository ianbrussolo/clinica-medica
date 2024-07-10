package org.climed.climed.controllers;

import org.climed.climed.model.Doenca;
import org.climed.climed.repository.DoencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doencas")
public class DoencaController {
    @Autowired
    private DoencaRepository doencaRepository;

    @GetMapping
    public List<Doenca> getAllDoencas() {
        return doencaRepository.findAll();
    }

    @PostMapping
    public Doenca createDoenca(@RequestBody Doenca doenca) {
        return doencaRepository.save(doenca);
    }
}