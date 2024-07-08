package org.climed.climed.repository;

import org.climed.climed.model.DiagnosticaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.climed.climed.model.Diagnostica;

public interface DiagnosticaRepository extends JpaRepository<Diagnostica, DiagnosticaId>{
}
