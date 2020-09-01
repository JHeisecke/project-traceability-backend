package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.FaseDTO;
import com.github.pol.una.traceability.exceptions.FaseException;

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
     * @throws FaseException
     */
    FaseDTO saveFase(FaseDTO fase);

    /**
     * Encontrar fases por id
     * @param id
     * @return
     * @throws FaseException
     */
    FaseDTO getById(Long id);

    /**
     * Encontrar fases por proyecto
     * @param idProyecto
     * @return
     * @throws FaseException
     */
    List<FaseDTO> getByIdProyecto(Long idProyecto);

}
