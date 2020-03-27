package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.UsuarioProyectoDTO;
import com.github.pol.una.traceability.entities.UsuarioProyecto;
import com.github.pol.una.traceability.mapper.impl.UsuarioProyectoMapper;
import com.github.pol.una.traceability.repository.UsuarioProyectoRepository;
import com.github.pol.una.traceability.service.UsuarioProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jvillagra
 */
@Service
public class UsuarioProyectoServiceImpl implements UsuarioProyectoService {

    @Autowired
    private UsuarioProyectoRepository repository;

    @Autowired
    private UsuarioProyectoMapper mapper;

    @Override
    public List<UsuarioProyectoDTO> getUsuariosByIdProyecto(Long idProyecto) {
        return mapper.mapAsList(repository.findByIdProyecto(idProyecto));
    }

    @Override
    public UsuarioProyectoDTO getUsuarioIfInProyecto(Long idProyecto, Long idUsuario) {
        return mapper.mapToDto(repository.findByIdProyectoAndIdUsuario(idProyecto, idUsuario));
    }

    @Override
    public void save(Long idUsuario, Long idProyecto) {
        UsuarioProyectoDTO usuarioProyecto = new UsuarioProyectoDTO();
        usuarioProyecto.setIdProyecto(idProyecto);
        usuarioProyecto.setIdUsuario(idUsuario);

        repository.save(mapper.mapToEntity(usuarioProyecto));
    }
}
