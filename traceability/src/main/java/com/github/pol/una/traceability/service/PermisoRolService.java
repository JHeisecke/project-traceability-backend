package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.PermisoDTO;
import com.github.pol.una.traceability.dto.PermisoRolDTO;

import java.util.List;

/**
 * @author jvillagra
 */
public interface PermisoRolService {

    List<PermisoDTO> getAllPermisosByRol(Long idRol);
}
