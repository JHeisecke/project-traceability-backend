package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.FaseDTO;
import com.github.pol.una.traceability.mapper.impl.FaseMapper;
import com.github.pol.una.traceability.repository.FaseRepository;
import com.github.pol.una.traceability.service.FaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author jvillagra
 * 2020-09-01
 */
@Service
public class FaseServiceImpl implements FaseService {

    @Autowired
    private FaseRepository faseRepository;

    @Autowired
    private FaseMapper mapper;

    @Override
    public FaseDTO saveFase(FaseDTO fase) {

        if(fase.getId() != null){
            fase.setFechaModificacion(new Date());
        }else{
            fase.setFechaAlta(new Date());
        }
        return mapper.mapToDto(faseRepository.save(mapper.mapToEntity(fase)));
    }

    @Override
    public FaseDTO getById(Long id){
        return mapper.mapToDto(faseRepository.findById(id));
    }

    @Override
    public List<FaseDTO> getByIdProyecto(Long idProyecto){
        return mapper.mapAsList(faseRepository.findByIdProyecto(idProyecto));
    }

    @Override
    public void deleteFasesByIdProyecto(Long idProyecto) {
        for(FaseDTO fase : getByIdProyecto(idProyecto)){
            faseRepository.deleteById(fase.getId());
        }
    }
}
