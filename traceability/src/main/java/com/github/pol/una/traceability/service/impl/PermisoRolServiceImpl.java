package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.PermisoDTO;
import com.github.pol.una.traceability.dto.PermisoRolDTO;
import com.github.pol.una.traceability.mapper.impl.PermisoRolMapper;
import com.github.pol.una.traceability.repository.PermisoRolRepository;
import com.github.pol.una.traceability.service.PermisoRolService;
import com.github.pol.una.traceability.service.PermisoService;
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


    @Override
    public List<PermisoDTO> getAllPermisosByRol(Long idRol) {
        List<PermisoRolDTO> permisosPorRol = mapper.mapAsList(permisoRolRepository.findByIdRol(idRol));
        List<PermisoDTO> permisos = new ArrayList<>();
        for(PermisoRolDTO permisoRolDTO : permisosPorRol){
            permisos.add(permisoService.getPermisosById(permisoRolDTO.getIdPermiso()));
        }
        return permisos;
    }
}
