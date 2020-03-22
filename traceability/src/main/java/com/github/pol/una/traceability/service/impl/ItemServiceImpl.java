package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.ItemDTO;
import com.github.pol.una.traceability.mapper.impl.ItemMapper;
import com.github.pol.una.traceability.repository.ItemRepository;
import com.github.pol.una.traceability.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author yedaloc
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemMapper mapper;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        if(itemDTO.getId() == null){
            itemDTO.setFechaAlta(new Date());
        }else{
            itemDTO.setFechaModificacion(new Date());
        }
        itemRepository.save(mapper.mapToEntity(itemDTO));
        return itemDTO;
    }


}
