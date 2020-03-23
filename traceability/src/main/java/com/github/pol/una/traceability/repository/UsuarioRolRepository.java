package com.github.pol.una.traceability.repository;

import com.github.pol.una.traceability.entities.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

    List<UsuarioRol> findByIdUsuario(Long idUsuario);

}
