package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.PermisoDTO;
import com.github.pol.una.traceability.mapper.impl.PermisoMapper;
import com.github.pol.una.traceability.repository.PermisoRepository;
import com.github.pol.una.traceability.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jvillagra
 */
@Service
public class PermisoServiceImpl implements PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private PermisoMapper mapper;


    @Override
    public PermisoDTO getPermisosById(Long id) {
        return mapper.mapToDto(permisoRepository.findById(id));
    }

    @Override
    public List<PermisoDTO> getAllPermisos() {
        return mapper.mapAsList(permisoRepository.findAll());
    }
}
