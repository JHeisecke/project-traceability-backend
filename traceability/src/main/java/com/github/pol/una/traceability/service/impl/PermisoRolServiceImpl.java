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
        List<PermisoRolDTO> permisosPorRol;
        List<PermisoDTO> listadoPermisos = permisoService.getAllPermisos();
        List<PermisoDTO> result = new ArrayList<>();
        for(PermisoDTO permisoEnListado : listadoPermisos){
            permisosPorRol = mapper
                    .mapAsList(permisoRolRepository.findByIdRolAndIdPermiso(idRol, permisoEnListado.getId()));
            if(!permisosPorRol.isEmpty()) {
                PermisoDTO permiso = permisoService.getPermisosById(permisoEnListado.getId());
                permiso.setRecursos(getListaRecursosPorPermiso(permisosPorRol));
                result.add(permiso);
            }
            permisosPorRol.clear();
        }
        return result;
    }

    private List<RecursoDTO> getListaRecursosPorPermiso(List<PermisoRolDTO> permisoRol) {
        List<RecursoDTO> recursos = new ArrayList<>();
        for(PermisoRolDTO permisoRolDTO : permisoRol){
            recursos.add(recursoService.getById(permisoRolDTO.getIdRecurso()));
        }
        return recursos;
    }

    @Override
    public List<PermisoDTO> asignarPermisosRol(List<PermisoDTO> permisos, Long idRol) {
        borrarPermisosRol(idRol);
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

    @Override
    public void borrarPermisosRol(Long idRol) {
        if(!permisoRolRepository.findByIdRol(idRol).isEmpty()) {
            permisoRolRepository.deleteByIdRol(idRol);
        }
    }
}
