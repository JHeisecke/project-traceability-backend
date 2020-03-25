package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.UsuarioRolDTO;
import com.github.pol.una.traceability.mapper.impl.UsuarioRolMapper;
import com.github.pol.una.traceability.repository.UsuarioRolRepository;
import com.github.pol.una.traceability.service.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jvillagra
 */
@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Autowired
    private UsuarioRolRepository repository;

    @Autowired
    private UsuarioRolMapper mapper;


    @Override
    public List<UsuarioRolDTO> getAllRolesUsuario(Long usuarioId) {
        return mapper.mapAsList(repository.findByIdUsuario(usuarioId));
    }

    @Override
    public void asignarRolUsuario(Long usuarioId, Long rolId) {
        UsuarioRolDTO usuarioRol = new UsuarioRolDTO();
        Boolean asignado = false;

        for(UsuarioRolDTO rolesUsuario : getAllRolesUsuario(usuarioId)){
            if (rolesUsuario.getIdRol().equals(rolId)){
                asignado = true;
            }
        }

        if(!asignado){
            usuarioRol.setIdRol(rolId);
            usuarioRol.setIdUsuario(usuarioId);
            repository.save(mapper.mapToEntity(usuarioRol));
        }
    }
}
