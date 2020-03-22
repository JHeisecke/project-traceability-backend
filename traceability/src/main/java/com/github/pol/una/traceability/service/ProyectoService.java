package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.ProyectoDTO;
import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.exceptions.ProjectException;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author jheisecke
 */
public interface ProyectoService {
    ProyectoDTO saveProject(ProyectoDTO proyectoDTO);

    List<ProyectoDTO> getAllProjects();

    ProyectoDTO getProjectById(Long id) throws ProjectException;

    void deleteProject(Long id) throws ProjectException;
}
