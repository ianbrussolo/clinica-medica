package org.climed.climed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.climed.climed.model.Doenca;

public interface DoencaRepository extends JpaRepository<Doenca, Integer> {
}
