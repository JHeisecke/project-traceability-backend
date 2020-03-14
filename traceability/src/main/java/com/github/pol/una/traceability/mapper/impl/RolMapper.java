package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.entities.Rol;
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
public class RolMapper implements BaseMapper<Rol, RolDTO> {

    private final OrikaBeanMapper mapper;

    public RolMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<RolDTO> mapAsList(List<Rol> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RolDTO mapToDto(Rol entity) {
        return mapper.map(entity, RolDTO.class);
    }

    @Override
    public Rol mapToEntity(RolDTO dto) {
        return mapper.map(dto, Rol.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }
}
