package org.climed.climed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.climed.climed.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
