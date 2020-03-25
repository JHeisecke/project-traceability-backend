package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.UsuarioRolDTO;

import java.util.List;

/**
 * @author jvillagra
 */
public interface UsuarioRolService {

    List<UsuarioRolDTO> getAllRolesUsuario(Long usuarioId);

    void asignarRolUsuario(Long usuarioId, Long rolId);
}
