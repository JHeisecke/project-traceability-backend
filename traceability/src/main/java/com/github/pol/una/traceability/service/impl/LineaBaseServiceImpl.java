package com.github.pol.una.traceability.service.impl;


import com.github.pol.una.traceability.dto.LineaBaseDTO;

import com.github.pol.una.traceability.entities.LineaBase;

import com.github.pol.una.traceability.exceptions.LineaBaseException;
import com.github.pol.una.traceability.mapper.impl.LineaBaseMapper;
import com.github.pol.una.traceability.repository.LineaBaseRepository;
import com.github.pol.una.traceability.service.LineaBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class LineaBaseServiceImpl implements LineaBaseService {

    @Autowired
    private LineaBaseRepository lineaBaseRepository;
    @Autowired
    private LineaBaseMapper lineaBaseMapper;

    @Override
    public LineaBaseDTO saveLineaBase(LineaBaseDTO lineaBaseDTO)  {

        if(lineaBaseDTO.getId() != null){
            lineaBaseDTO.setFechaModificacion(new Date());
        }else{
            lineaBaseDTO.setFechaAlta(new Date());
        }

        LineaBase lineaBase = lineaBaseMapper.mapToEntity(lineaBaseDTO);

        return lineaBaseMapper.mapToDto( lineaBaseRepository.save(lineaBase));
    }


    @Override
    public List<LineaBaseDTO> getAllLineaBase() {
       return lineaBaseMapper.mapAsList(lineaBaseRepository.findAll());
    }

    @Override
    public LineaBaseDTO getLineaBaseById(Long id) throws LineaBaseException {
        Optional<LineaBase> lineabase = lineaBaseRepository.findById(id);
        if(lineabase.isPresent()) {
            return lineaBaseMapper.mapToDto(lineabase.get());
        } else {
            throw new LineaBaseException("notFound", "No se encontró la linea base "+id);
        }
    }

    @Override
    public List<LineaBaseDTO> getLineaBaseByProyecto(Long idProyecto) {
        return lineaBaseMapper.mapAsList(lineaBaseRepository.findByIdProyecto(idProyecto));
    }
}
