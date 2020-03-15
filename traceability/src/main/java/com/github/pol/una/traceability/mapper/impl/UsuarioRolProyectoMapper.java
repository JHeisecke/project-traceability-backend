package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.UsuarioRolProyectoDTO;
import com.github.pol.una.traceability.entities.UsuarioRolProyecto;
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
public class UsuarioRolProyectoMapper implements BaseMapper<UsuarioRolProyecto, UsuarioRolProyectoDTO> {

    private final OrikaBeanMapper mapper;

    public UsuarioRolProyectoMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<UsuarioRolProyectoDTO> mapAsList(List<UsuarioRolProyecto> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioRolProyectoDTO mapToDto(UsuarioRolProyecto entity) {
        return mapper.map(entity, UsuarioRolProyectoDTO.class);
    }

    @Override
    public UsuarioRolProyecto mapToEntity(UsuarioRolProyectoDTO dto) {
        return mapper.map(dto, UsuarioRolProyecto.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }
}
