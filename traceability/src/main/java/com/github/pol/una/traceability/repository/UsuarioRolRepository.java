package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.entities.UsuarioRolProyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRolProyectoRepository extends JpaRepository<UsuarioRolProyecto, Long> {

    List<UsuarioRolProyecto> findByIdProyectoAndAndIdUsuario(Long idProyecto, Long idUsuario);

    List<UsuarioRolProyecto> findByIdUsuario(Long idUsuario);

}
