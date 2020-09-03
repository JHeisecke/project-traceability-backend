package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.LineaBaseDTO;
import com.github.pol.una.traceability.dto.ProyectoDTO;
import com.github.pol.una.traceability.entities.LineaBase;
import com.github.pol.una.traceability.exceptions.ProjectException;


import java.util.List;

/**
 * @author yedaloc
 */

public interface LineaBaseService {


    LineaBaseDTO saveLineaBase(LineaBaseDTO lineabaseDTO);

    void deleteLineabase(Long id);

    List<LineaBaseDTO> getAllLineaBase();

    LineaBaseDTO getLineaBaseById(Long id) ;




}

