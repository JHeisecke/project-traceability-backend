package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.UsuarioRolProyectoDTO;
import com.github.pol.una.traceability.entities.UsuarioRolProyecto;
import com.github.pol.una.traceability.mapper.impl.UsuarioRolProyectoMapper;
import com.github.pol.una.traceability.repository.UsuarioRolProyectoRepository;
import com.github.pol.una.traceability.service.UsuarioRolProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jvillagra
 */
@Service
public class UsuarioRolProyectoServiceImpl implements UsuarioRolProyectoService{

    @Autowired
    private UsuarioRolProyectoRepository repository;

    @Autowired
    private UsuarioRolProyectoMapper mapper;


    @Override
    public List<UsuarioRolProyectoDTO> getAllRolesUsuario(Long usuarioId) {
        return mapper.mapAsList(repository.findByIdUsuario(usuarioId));
    }

    @Override
    public void asignarRolUsuario(Long usuarioId, Long rolId) {
        UsuarioRolProyectoDTO usuarioRolProyecto = new UsuarioRolProyectoDTO();
        Boolean asignado = false;
        for(UsuarioRolProyectoDTO rolesUsuario : getAllRolesUsuario(usuarioId)){
            if (rolesUsuario.getIdRol().equals(rolId)){
                asignado = true;
            }
        }
        if(!asignado){
            usuarioRolProyecto.setIdRol(rolId);
            usuarioRolProyecto.setIdUsuario(usuarioId);
            repository.save(mapper.mapToEntity(usuarioRolProyecto));
        }
    }
}
