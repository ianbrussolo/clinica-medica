package org.climed.climed.repository;

import org.climed.climed.model.Consulta;
import org.climed.climed.model.Medico;
import org.climed.climed.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
    List<Consulta> findByPaciente(Paciente paciente);
    List<Consulta> findByMedico(Medico medico);
}
