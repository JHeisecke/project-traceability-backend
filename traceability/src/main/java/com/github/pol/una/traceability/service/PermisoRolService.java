package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.PermisoDTO;

import java.util.List;

/**
 * @author jvillagra
 */
public interface PermisoRolService {

    List<PermisoDTO> getAllPermisosByRol(Long idRol);

    List<PermisoDTO> asignarPermisosRol(List<PermisoDTO> permisos, Long idRol);
}
