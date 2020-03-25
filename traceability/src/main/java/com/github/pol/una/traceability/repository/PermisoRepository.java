package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.dto.PermisoDTO;
import com.github.pol.una.traceability.entities.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jvillagra
 */
public interface PermisoRepository extends JpaRepository<Permiso, PermisoDTO> {

    Permiso findById(Long id);
}
