package com.github.pol.una.traceability.service.impl;


import com.github.pol.una.traceability.dto.LineaBaseDTO;

import com.github.pol.una.traceability.dto.ProyectoDTO;
import com.github.pol.una.traceability.entities.LineaBase;

import com.github.pol.una.traceability.entities.Proyecto;
import com.github.pol.una.traceability.exceptions.LineaBaseException;
import com.github.pol.una.traceability.exceptions.ProjectException;
import com.github.pol.una.traceability.mapper.impl.LineaBaseMapper;
import com.github.pol.una.traceability.repository.LineaBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LineaBaseServiceImpl {

    @Autowired
    private LineaBaseRepository lineabaseRepository;
    @Autowired
    private LineaBaseMapper lineaBaseMapper;

    public LineaBaseDTO saveLineaBase(LineaBaseDTO lineabaseDTO) {
        LineaBase lineabase = lineaBaseMapper.mapToEntity(lineabaseDTO);
        lineabaseRepository.save(lineabase);

        return lineabaseDTO;
    }

    @Override
    public void deleteLineaBase(Long id)  {
        Optional<LineaBase> lineabase = lineabaseRepository.findById(id);
        if(lineabase.isPresent()) {
            lineabaseRepository.delete(lineabase.get());
        } else {
            throw new LineaBaseException("notFound", "No se encontró la linea base "+id);
        }
    }

    @Override
    public List<LineaBaseDTO> getAllLineaBase() {
        List<LineaBase> listaLineaBase = lineabaseRepository.findAll();
        List<LineaBaseDTO> lineabaseDTOS = new ArrayList<>();
        for(LineaBase liba : listaLineaBase){
            LineaBaseDTO lineabaseDTO = lineaBaseMapper.mapToDto(liba);
            lineabaseDTOS.add(lineabaseDTO);
        }
        return lineabaseDTOS;
    }

    @Override
    public ProyectoDTO getLineaBaseById(Long id) {
        Optional<LineaBase> lineabase = lineabaseRepository.findById(id);
        if(lineabase.isPresent()) {
            return lineaBaseMapper.mapToDto(lineabase.get());
        } else {
            throw new LineaBaseException("notFound", "No se encontró la linea base "+id);
        }
    }



}
