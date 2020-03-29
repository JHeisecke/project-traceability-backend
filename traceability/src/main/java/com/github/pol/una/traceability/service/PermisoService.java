package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.PermisoDTO;

import java.util.List;

/**
 * @author jvillagra
 */
public interface PermisoService {

    PermisoDTO getPermisosById(Long id);

    List<PermisoDTO> getAllPermisos();
}
