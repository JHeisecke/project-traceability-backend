package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioRolProyectoDTO;
import com.github.pol.una.traceability.entities.Rol;
import com.github.pol.una.traceability.entities.UsuarioRolProyecto;
import com.github.pol.una.traceability.exceptions.RolException;
import com.github.pol.una.traceability.mapper.impl.RolMapper;
import com.github.pol.una.traceability.repository.RolRepository;
import com.github.pol.una.traceability.service.RolService;
import com.github.pol.una.traceability.service.UsuarioRolProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author jvillagra
 */
@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private RolMapper rolMapper;

    @Autowired
    private UsuarioRolProyectoService usuarioRolProyectoService;

    @Override
    public List<RolDTO> getAll(){
        List<Rol> listaRoles = rolRepository.findAll();
        List<RolDTO> rolDTOS = new ArrayList<>();
        for(Rol rol : listaRoles){
            rolDTOS.add(rolMapper.mapToDto(rol));
        }
        return rolDTOS;
    }
    @Override
    public RolDTO getRolById(Long id) throws RolException {
        Optional<Rol> rol = rolRepository.findById(id);
        if(rol.isPresent()) {
            return rolMapper.mapToDto(rol.get());
        } else {
            throw new RolException("notFound", "No se encontró el rol");
        }
    }

    @Override
    public RolDTO getRolByNombre(String nombre) throws RolException {
        Optional<Rol> rol = rolRepository.findByNombre(nombre);
        if(rol.isPresent()) {
            return rolMapper.mapToDto(rol.get());
        } else {
            throw new RolException("notFound", "No se encontró el rol");
        }
    }


    @Override
    public List<RolDTO> getRolesByUsuarioId(Long usuarioId) throws RolException {

        List<UsuarioRolProyectoDTO> usuarioRolesProyectos = usuarioRolProyectoService.getAllRolesUsuario(usuarioId);
        List<RolDTO> rolesUsuario = new ArrayList<>();

        if(usuarioRolesProyectos != null){
            for(UsuarioRolProyectoDTO urp : usuarioRolesProyectos){
                rolesUsuario.add(this.getRolById(urp.getIdRol()));
            }

        }
        return rolesUsuario;
    }
}
