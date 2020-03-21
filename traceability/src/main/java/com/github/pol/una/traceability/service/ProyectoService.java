package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.ProyectoDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;

import java.util.List;

/**
 * @author jheisecke
 */
public interface ProyectoService {
    ProyectoDTO saveProject(ProyectoDTO proyectoDTO);

    List<ProyectoDTO> getAllProjects();
}
