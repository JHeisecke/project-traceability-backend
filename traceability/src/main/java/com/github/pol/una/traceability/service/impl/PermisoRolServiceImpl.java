package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.PermisoDTO;
import com.github.pol.una.traceability.dto.PermisoRolDTO;
import com.github.pol.una.traceability.dto.RecursoDTO;
import com.github.pol.una.traceability.mapper.impl.PermisoRolMapper;
import com.github.pol.una.traceability.repository.PermisoRolRepository;
import com.github.pol.una.traceability.service.PermisoRolService;
import com.github.pol.una.traceability.service.PermisoService;
import com.github.pol.una.traceability.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jvillagra
 */
@Service
public class PermisoRolServiceImpl implements PermisoRolService {

    @Autowired
    private PermisoRolRepository permisoRolRepository;

    @Autowired
    private PermisoRolMapper mapper;

    @Autowired
    private PermisoService permisoService;

    @Autowired
    private RecursoService recursoService;

    @Override
    public List<PermisoDTO> getAllPermisosByRol(Long idRol) {
        List<PermisoRolDTO> permisosPorRol = mapper.mapAsList(permisoRolRepository.findByIdRol(idRol));
        List<PermisoDTO> permisos = new ArrayList<>();
        Boolean cargado = false;

        for(PermisoRolDTO permisoRolDTO : permisosPorRol){

            List<PermisoRolDTO> permisoDeRol = mapper.mapAsList(permisoRolRepository
                    .findByIdRolAndIdPermiso(idRol, permisoRolDTO.getIdPermiso()));
            List<RecursoDTO> recursosPorPermiso = new ArrayList<>();

            for(PermisoRolDTO permisoRol : permisoDeRol) {
                RecursoDTO recurso = recursoService.getById(permisoRol.getIdRecurso());
                if(recurso != null) {
                    for(RecursoDTO recursoDTO : recursosPorPermiso){
                        if (recursoDTO == recurso){
                            cargado = true;
                        }
                    }
                    if(!cargado) {
                        recursosPorPermiso.add(recurso);
                    }
                    cargado = false;
                }
            }
            PermisoDTO permiso = permisoService.getPermisosById(permisoRolDTO.getIdPermiso());
            permiso.setRecursos(recursosPorPermiso);
            for(PermisoDTO permisoEnLista : permisos){
                if(permisoEnLista.getId().equals(permiso.getId())){
                    cargado = true;
                }
            }
            if(!cargado) {
                permisos.add(permiso);
            }

        }
        return permisos;
    }

    @Override
    public List<PermisoDTO> asignarPermisosRol(List<PermisoDTO> permisos, Long idRol) {

        for(PermisoDTO permiso : permisos){
            for(RecursoDTO recursoDTO : permiso.getRecursos()){
                if(permisoRolRepository.findByIdRolAndIdPermisoAndIdRecurso(idRol, permiso.getId(), recursoDTO.getId() )
                         == null) {
                    PermisoRolDTO permisoRol = new PermisoRolDTO();
                    permisoRol.setIdPermiso(permiso.getId());
                    permisoRol.setIdRol(idRol);
                    permisoRol.setIdRecurso(recursoDTO.getId());
                    permisoRolRepository.save(mapper.mapToEntity(permisoRol));
                }
            }
        }
        return permisos;
    }
}
