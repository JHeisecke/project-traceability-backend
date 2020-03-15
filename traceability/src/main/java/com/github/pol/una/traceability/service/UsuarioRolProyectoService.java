package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.UsuarioRolProyectoDTO;

import java.util.List;

/**
 * @author jvillagra
 */
public interface UsuarioRolProyectoService {

    List<UsuarioRolProyectoDTO> getAllRolesUsuario(Long usuarioId);
}
