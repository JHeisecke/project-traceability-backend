package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.dto.UsuarioProyectoDTO;
import com.github.pol.una.traceability.entities.UsuarioProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jvillagra
 */

public interface UsuarioProyectoRepository extends JpaRepository<UsuarioProyecto, UsuarioProyectoDTO> {

    List<UsuarioProyecto> findByIdProyecto(Long idProyecto);

    UsuarioProyecto findByIdProyectoAndIdUsuario(Long idProyecto, Long idUsuario);
}
