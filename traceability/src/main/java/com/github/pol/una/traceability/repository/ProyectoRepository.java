package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author jheisecke
 */
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    Optional<Proyecto> findById(Long id);
}
