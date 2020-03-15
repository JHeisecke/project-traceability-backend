package com.github.pol.una.traceability.mapper.impl;

import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Rol;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.mapper.BaseMapper;
import com.github.pol.una.traceability.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author jheisecke
 */
@Component
public class UsuarioMapper implements BaseMapper<Usuario, UsuarioDTO> {

    private final OrikaBeanMapper mapper;

    public UsuarioMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<UsuarioDTO> mapAsList(List<Usuario> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO mapToDto(Usuario entity) {
        return mapper.map(entity, UsuarioDTO.class);
    }

    @Override
    public Usuario mapToEntity(UsuarioDTO dto) {
        return mapper.map(dto, Usuario.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }
}
