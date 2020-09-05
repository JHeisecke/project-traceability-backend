package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.FaseDTO;
import com.github.pol.una.traceability.entities.Fase;
import com.github.pol.una.traceability.mapper.BaseMapper;
import com.github.pol.una.traceability.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author jvillagra
 * 2020-09-01
 */
@Component
public class FaseMapper implements BaseMapper<Fase, FaseDTO> {

    private final OrikaBeanMapper mapper;

    public FaseMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<FaseDTO> mapAsList(List<Fase> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FaseDTO mapToDto(Fase entity) {
        return mapper.map(entity, FaseDTO.class);
    }

    @Override
    public Fase mapToEntity(FaseDTO dto) {
        return mapper.map(dto, Fase.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
