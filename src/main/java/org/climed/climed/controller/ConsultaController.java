package org.climed.climed.controller;

import org.climed.climed.model.Consulta;
import org.climed.climed.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaRepository.save(consulta);
    }
}
