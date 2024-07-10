package org.climed.climed.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.climed.climed.exception.ResourceNotFoundException;
import org.climed.climed.model.*;
import org.climed.climed.repository.ConsultaRepository;
import org.climed.climed.repository.EspecialidadeRepository;
import org.climed.climed.repository.MedicoRepository;
import org.climed.climed.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Consulta> createConsulta(@Valid @RequestBody ConsultaRequestDTO consultaRequestDTO) {
        Medico medico = medicoRepository.findById(consultaRequestDTO.getCrm())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com CRM: " + consultaRequestDTO.getCrm()));

        Especialidade especialidade = especialidadeRepository.findById(consultaRequestDTO.getIdEsp())
                .orElseThrow(() -> new EntityNotFoundException("Especialidade não encontrada com ID: " + consultaRequestDTO.getIdEsp()));

        Paciente paciente = pacienteRepository.findByCpf(consultaRequestDTO.getCpf())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com CPF: " + consultaRequestDTO.getCpf()));

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setEspecialidade(especialidade);
        consulta.setPaciente(paciente);
        consulta.setData(consultaRequestDTO.getData());
        consulta.setHorainiccon(LocalTime.parse(consultaRequestDTO.getHoraInicCon()));
        consulta.setHorafimcon(LocalTime.parse(consultaRequestDTO.getHoraFimCon()));
        consulta.setPagou(consultaRequestDTO.isPagou());
        consulta.setValorpago(consultaRequestDTO.getValorPago());
        consulta.setFormapagamento(consultaRequestDTO.getFormaPagamento());

        consulta = consultaRepository.save(consulta);

        return ResponseEntity.ok(consulta);
    }

    @GetMapping("/{id}")
    public Consulta getConsulta(@PathVariable int id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta not found with id: " + id));
    }

    @GetMapping("/paciente/{cpf}")
    public ResponseEntity<List<Consulta>> getConsultasPorPaciente(@PathVariable String cpf) {
        Paciente paciente = pacienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com CPF: " + cpf));

        List<Consulta> consultas = consultaRepository.findByPaciente(paciente);

        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/medico/{crm}")
    public ResponseEntity<List<Consulta>> getConsultasPorMedico(@PathVariable String crm) {
        Medico medico = medicoRepository.findById(crm)
                .orElseThrow(() -> new EntityNotFoundException("Medico não encontrado com CRM: " + crm));

        List<Consulta> consultas = consultaRepository.findByMedico(medico);

        return ResponseEntity.ok(consultas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        Optional<Consulta> optionalConsulta = consultaRepository.findById(id);
        if (!optionalConsulta.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Consulta consulta = optionalConsulta.get();

        if (updates.containsKey("crm")) {
            Optional<Medico> medicoOptional = medicoRepository.findById(updates.get("crm").toString());
            if (!medicoOptional.isPresent()) {
                return ResponseEntity.badRequest().body(null);
            }
            consulta.setMedico(medicoOptional.get());
        }
        if (updates.containsKey("idEsp")) {
            Optional<Especialidade> especialidadeOptional = especialidadeRepository.findById((Integer) updates.get("idEsp"));
            if (!especialidadeOptional.isPresent()) {
                return ResponseEntity.badRequest().body(null);
            }
            consulta.setEspecialidade(especialidadeOptional.get());
        }
        if (updates.containsKey("cpf")) {
            Optional<Paciente> pacienteOptional = pacienteRepository.findByCpf(updates.get("cpf").toString());
            if (!pacienteOptional.isPresent()) {
                return ResponseEntity.badRequest().body(null);
            }
            consulta.setPaciente(pacienteOptional.get());
        }
        if (updates.containsKey("data")) {
            consulta.setData(LocalDate.parse(updates.get("data").toString()));
        }
        if (updates.containsKey("horaInicCon")) {
            consulta.setHorainiccon(LocalTime.parse(updates.get("horaInicCon").toString()));
        }
        if (updates.containsKey("horaFimCon")) {
            consulta.setHorafimcon(LocalTime.parse(updates.get("horaFimCon").toString()));
        }
        if (updates.containsKey("pagou")) {
            consulta.setPagou(Boolean.parseBoolean(updates.get("pagou").toString()));
        }
        if (updates.containsKey("valorpago")) {
            consulta.setValorpago(Integer.getInteger(updates.get("valorpago").toString()));
        }
        if (updates.containsKey("formapagamento")) {
            consulta.setFormapagamento(updates.get("formapagamento").toString());
        }
        Consulta updatedConsulta = consultaRepository.save(consulta);
        return ResponseEntity.ok(updatedConsulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable int id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com ID: " + id));

        consultaRepository.delete(consulta);

        return ResponseEntity.noContent().build();
    }
}
