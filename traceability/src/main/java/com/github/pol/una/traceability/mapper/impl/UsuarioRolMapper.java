package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.UsuarioRolDTO;
import com.github.pol.una.traceability.entities.UsuarioRol;
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
public class UsuarioRolMapper implements BaseMapper<UsuarioRol, UsuarioRolDTO> {

    private final OrikaBeanMapper mapper;

    public UsuarioRolMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<UsuarioRolDTO> mapAsList(List<UsuarioRol> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioRolDTO mapToDto(UsuarioRol entity) {
        return mapper.map(entity, UsuarioRolDTO.class);
    }

    @Override
    public UsuarioRol mapToEntity(UsuarioRolDTO dto) {
        return mapper.map(dto, UsuarioRol.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }
}
