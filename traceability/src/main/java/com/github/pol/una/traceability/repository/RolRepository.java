package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author jvillagra
 */
public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombre(String nombre);

    Optional<Rol> findById(Long id);

}
