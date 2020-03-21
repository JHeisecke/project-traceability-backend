package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.entities.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jheisecke
 */
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
