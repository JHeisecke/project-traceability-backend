package com.github.pol.una.traceability.service.impl;


import com.github.pol.una.traceability.dto.LineaBaseDTO;

import com.github.pol.una.traceability.entities.LineaBase;

import com.github.pol.una.traceability.exceptions.LineaBaseException;
import com.github.pol.una.traceability.mapper.impl.LineaBaseMapper;
import com.github.pol.una.traceability.repository.LineaBaseRepository;
import com.github.pol.una.traceability.service.LineaBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LineaBaseServiceImpl implements LineaBaseService {

    @Autowired
    private LineaBaseRepository lineaBaseRepository;
    @Autowired
    private LineaBaseMapper lineaBaseMapper;

    public LineaBaseDTO saveLineaBase(LineaBaseDTO lineaBaseDTO)  {
        LineaBase lineaBase = lineaBaseMapper.mapToEntity(lineaBaseDTO);
        lineaBaseRepository.save(lineaBase);

        return lineaBaseDTO;
    }

    @Override
    public void deleteLineaBase(Long id) throws LineaBaseException {
        Optional<LineaBase> lineabase = lineaBaseRepository.findById(id);
        if(lineabase.isPresent()) {
            lineaBaseRepository.delete(lineabase.get());
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
    public LineaBaseDTO getLineaBaseById(Long id) throws LineaBaseException {
        Optional<LineaBase> lineabase = lineabaseRepository.findById(id);
        if(lineabase.isPresent()) {
            return lineaBaseMapper.mapToDto(lineabase.get());
        } else {
            throw new LineaBaseException("notFound", "No se encontró la linea base "+id);
        }
    }



}
