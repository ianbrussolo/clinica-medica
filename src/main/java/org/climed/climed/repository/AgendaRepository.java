package org.climed.climed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.climed.climed.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Integer>{
}
