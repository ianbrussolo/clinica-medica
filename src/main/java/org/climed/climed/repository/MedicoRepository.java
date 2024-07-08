package org.climed.climed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.climed.climed.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String> {
}
