package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.PermisoRolDTO;
import com.github.pol.una.traceability.entities.PermisoRol;
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
public class PermisoRolMapper implements BaseMapper<PermisoRol, PermisoRolDTO> {

    private final OrikaBeanMapper mapper;

    public PermisoRolMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<PermisoRolDTO> mapAsList(List<PermisoRol> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PermisoRolDTO mapToDto(PermisoRol entity) {
        return mapper.map(entity, PermisoRolDTO.class);
    }

    @Override
    public PermisoRol mapToEntity(PermisoRolDTO dto) {
        return mapper.map(dto, PermisoRol.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }
}
