package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioRolDTO;
import com.github.pol.una.traceability.entities.Rol;
import com.github.pol.una.traceability.exceptions.RolException;
import com.github.pol.una.traceability.mapper.impl.RolMapper;
import com.github.pol.una.traceability.repository.RolRepository;
import com.github.pol.una.traceability.service.PermisoRolService;
import com.github.pol.una.traceability.service.RolService;
import com.github.pol.una.traceability.service.UsuarioRolService;
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
    private UsuarioRolService usuarioRolService;

    @Autowired
    private PermisoRolService permisoRolService;

    @Override
    public List<RolDTO> getAll(){
        List<Rol> listaRoles = rolRepository.findAll();
        List<RolDTO> rolDTOS = new ArrayList<>();
        for(Rol rol : listaRoles){
            RolDTO rolDTO = rolMapper.mapToDto(rol);
            rolDTO.setPermisos(permisoRolService.getAllPermisosByRol(rol.getId()));
            rolDTOS.add(rolDTO);
        }
        return rolDTOS;
    }
    @Override
    public RolDTO getRolById(Long id) throws RolException {
        Optional<Rol> rol = rolRepository.findById(id);
        if(rol.isPresent()) {
            RolDTO rolDTO = rolMapper.mapToDto(rol.get());
            rolDTO.setPermisos(permisoRolService.getAllPermisosByRol(rol.get().getId()));
            return rolDTO;
        } else {
            throw new RolException("notFound", "No se encontró el rol");
        }
    }

    @Override
    public RolDTO getRolByNombre(String nombre) throws RolException {
        Optional<Rol> rol = rolRepository.findByNombre(nombre);
        if(rol.isPresent()) {
            RolDTO rolDTO = rolMapper.mapToDto(rol.get());
            rolDTO.setPermisos(permisoRolService.getAllPermisosByRol(rol.get().getId()));
            return rolDTO;
        } else {
            throw new RolException("notFound", "No se encontró el rol");
        }
    }


    @Override
    public List<RolDTO> getRolesByUsuarioId(Long usuarioId) throws RolException {

        List<UsuarioRolDTO> usuarioRoles = usuarioRolService.getAllRolesUsuario(usuarioId);
        List<RolDTO> rolesUsuario = new ArrayList<>();

        if(usuarioRoles != null){
            for(UsuarioRolDTO usuarioRol : usuarioRoles){
                RolDTO rol = this.getRolById(usuarioRol.getIdRol());
                rol.setPermisos(permisoRolService.getAllPermisosByRol(rol.getId()));
                rolesUsuario.add(rol);
            }
        }
        return rolesUsuario;
    }

    @Override
    public RolDTO save(RolDTO rol) {

        rolRepository.save(rolMapper.mapToEntity(rol));
        permisoRolService.asignarPermisosRol(rol.getPermisos(), rol.getId());
        return rol;
    }

    @Override
    public void deleteRol(Long idRol) {
        Optional<Rol> rol = rolRepository.findById(idRol);
        rol.ifPresent(value -> rolRepository.delete(value));
    }
}
