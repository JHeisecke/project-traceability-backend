package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.ProyectoDTO;
import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.dto.UsuarioDTO;
import com.github.pol.una.traceability.entities.Proyecto;
import com.github.pol.una.traceability.entities.Usuario;
import com.github.pol.una.traceability.mapper.impl.ProyectoMapper;
import com.github.pol.una.traceability.mapper.impl.UsuarioMapper;
import com.github.pol.una.traceability.repository.ProyectoRepository;
import com.github.pol.una.traceability.repository.UsuarioRepository;
import com.github.pol.una.traceability.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jheisecke
 */
@Service
public class ProyectoServiceImpl  implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;
    @Autowired
    private ProyectoMapper mapper;

    @Override
    public ProyectoDTO saveProject(ProyectoDTO proyectoDTO) {
        if(proyectoDTO.getId() == null){
            proyectoDTO.setFechaAlta(new Date());
        }else{
            proyectoDTO.setFechaModificacion(new Date());
        }
        proyectoRepository.save(mapper.mapToEntity(proyectoDTO));
        return proyectoDTO;
    }

    @Override
    public List<ProyectoDTO> getAllProjects() {
        List<Proyecto> listaProyectos = proyectoRepository.findAll();
        List<ProyectoDTO> proyectoDTOS = new ArrayList<>();
        for(Proyecto proy : listaProyectos){
            ProyectoDTO proyectoDTO = mapper.mapToDto(proy);
            proyectoDTOS.add(proyectoDTO);
        }
        return proyectoDTOS;
    }

}
