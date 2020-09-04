package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.LineaBaseDTO;

import com.github.pol.una.traceability.entities.LineaBase;
import com.github.pol.una.traceability.exceptions.LineaBaseException;



import java.util.List;

/**
 * @author yedaloc
 */

public interface LineaBaseService {


    LineaBaseDTO saveLineaBase(LineaBaseDTO lineabaseDTO) throws LineaBaseException;

    void deleteLineaBase(Long id) throws LineaBaseException;

    List<LineaBaseDTO> getAllLineaBase();

    LineaBaseDTO getLineaBaseById(Long id) throws LineaBaseException;




}

