package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.UsuarioProyectoDTO;

import java.util.List;

/**
 * @author jvillagra
 */
public interface UsuarioProyectoService {

    List<UsuarioProyectoDTO> getUsuariosByIdProyecto(Long idProyecto);

    UsuarioProyectoDTO getUsuarioIfInProyecto(Long idProyecto, Long idUsuario);

    void save(Long idUsuario, Long idProyecto);

}
