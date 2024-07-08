package org.climed.climed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.climed.climed.model.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long>{
}
