package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.RecursoDTO;

import java.util.List;

/**
 * @author jvillagra
 */
public interface RecursoService {

    RecursoDTO getById(Long id);

    List<RecursoDTO> getAllRecursos();
}
