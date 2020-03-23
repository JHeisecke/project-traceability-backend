package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.PermisoDTO;
import com.github.pol.una.traceability.entities.Permiso;
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
public class PermisoMapper implements BaseMapper<Permiso, PermisoDTO> {

    private final OrikaBeanMapper mapper;

    public PermisoMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<PermisoDTO> mapAsList(List<Permiso> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PermisoDTO mapToDto(Permiso entity) {
        return mapper.map(entity, PermisoDTO.class);
    }

    @Override
    public Permiso mapToEntity(PermisoDTO dto) {
        return mapper.map(dto, Permiso.class);
    }

    @Override
    public MapperFacade getMapper() {
        return null;
    }
}
