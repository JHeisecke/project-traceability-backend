package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.FaseDTO;

import java.util.List;

/**
 * @author jvillagra
 * 2020-09-01
 */
public interface FaseService {
    /**
     * Guardar nueva fase
     * @param fase
     * @return
     */
    FaseDTO saveFase(FaseDTO fase);

    /**
     * Encontrar fases por id
     * @param id
     * @return
     */
    FaseDTO getById(Long id);

    /**
     * Encontrar fases por proyecto
     * @param idProyecto
     * @return
     */
    List<FaseDTO> getByIdProyecto(Long idProyecto);

    /**
     * Delete fases de un proyecto
     */
    void deleteFasesByIdProyecto(Long idProyecto);
}
