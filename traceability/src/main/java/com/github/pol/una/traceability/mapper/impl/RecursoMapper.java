package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.RecursoDTO;
import com.github.pol.una.traceability.entities.Recurso;
import com.github.pol.una.traceability.mapper.BaseMapper;
import com.github.pol.una.traceability.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author jvillagra
 */
@Component
public class RecursoMapper implements BaseMapper<Recurso, RecursoDTO> {

    private final OrikaBeanMapper mapper;

    public RecursoMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<RecursoDTO> mapAsList(List<Recurso> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecursoDTO mapToDto(Recurso entity) {
        return mapper.map(entity, RecursoDTO.class);
    }

    @Override
    public Recurso mapToEntity(RecursoDTO dto) {
        return mapper.map(dto, Recurso.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }
}
