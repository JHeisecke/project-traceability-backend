package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.LineaBaseDTO;

import com.github.pol.una.traceability.entities.LineaBase;
import com.github.pol.una.traceability.mapper.BaseMapper;
import com.github.pol.una.traceability.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yedaloc
 */
@Component
public class LineaBaseMapper implements BaseMapper<LineaBase, LineaBaseDTO> {

    private final OrikaBeanMapper mapper;

    public LineaBaseMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<LineaBaseDTO> mapAsList(List<LineaBase> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LineaBaseDTO mapToDto(LineaBase entity) {
        return mapper.map(entity, LineaBaseDTO.class);
    }

    @Override
    public LineaBase mapToEntity(LineaBaseDTO dto) {
        return mapper.map(dto, LineaBase.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }

}