package org.climed.climed.controllers;

import org.climed.climed.model.Exerceesp;
import org.climed.climed.repository.ExerceespRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exerceesp")
public class ExerceespController {
    @Autowired
    private ExerceespRepository exerceespRepository;

    @GetMapping
    public List<Exerceesp> getAllExerceesps() {
        return exerceespRepository.findAll();
    }

    @PostMapping
    public Exerceesp createAgenda(@RequestBody Exerceesp exerceesp) {
        return exerceespRepository.save(exerceesp);
    }
}

