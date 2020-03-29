package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.RecursoDTO;
import com.github.pol.una.traceability.entities.Recurso;
import com.github.pol.una.traceability.mapper.impl.RecursoMapper;
import com.github.pol.una.traceability.repository.RecursoRepository;
import com.github.pol.una.traceability.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author jvillagra
 */
@Service
public class RecursoServiceImpl implements RecursoService {

    @Autowired
    private RecursoMapper mapper;

    @Autowired
    private RecursoRepository repository;
    @Override
    public RecursoDTO getById(Long id) {
        Optional<Recurso> recursoById = repository.findById(id);
        if(recursoById.isPresent()) {
            return mapper.mapToDto(recursoById.get());
        }else{
            return null;
        }
    }

    @Override
    public List<RecursoDTO> getAllRecursos() {
        return mapper.mapAsList(repository.findAll());
    }
}
