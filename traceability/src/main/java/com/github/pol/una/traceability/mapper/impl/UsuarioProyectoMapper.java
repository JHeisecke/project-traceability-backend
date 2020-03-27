package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.UsuarioProyectoDTO;
import com.github.pol.una.traceability.entities.UsuarioProyecto;
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
public class UsuarioProyectoMapper implements BaseMapper<UsuarioProyecto, UsuarioProyectoDTO> {

    private OrikaBeanMapper mapper;

    public UsuarioProyectoMapper(OrikaBeanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<UsuarioProyectoDTO> mapAsList(List<UsuarioProyecto> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioProyectoDTO mapToDto(UsuarioProyecto entity) {
        return mapper.map(entity, UsuarioProyectoDTO.class);
    }

    @Override
    public UsuarioProyecto mapToEntity(UsuarioProyectoDTO dto) {
        return mapper.map(dto, UsuarioProyecto.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }
}
