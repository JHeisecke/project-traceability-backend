package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.ProyectoDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Proyecto;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.mapper.BaseMapper;
import com.github.pol.una.traceability.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProyectoMapper implements BaseMapper<Proyecto, ProyectoDTO> {

    private final OrikaBeanMapper mapper;

    public ProyectoMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<ProyectoDTO> mapAsList(List<Proyecto> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProyectoDTO mapToDto(Proyecto entity) {
        return mapper.map(entity, ProyectoDTO.class);
    }

    @Override
    public Proyecto mapToEntity(ProyectoDTO dto) {
        return mapper.map(dto, Proyecto.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }
}
