package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.ItemDTO;
import com.github.pol.una.traceability.entities.Item;
import com.github.pol.una.traceability.exceptions.ItemException;
import com.github.pol.una.traceability.mapper.impl.ItemMapper;
import com.github.pol.una.traceability.repository.ItemRepository;
import com.github.pol.una.traceability.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author yedaloc
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) throws ItemException {
        if(itemDTO.getId() == null){
            itemDTO.setFechaAlta(new Date());
        }else{
            itemDTO.setFechaModificacion(new Date());
        }
        itemRepository.save(itemMapper.mapToEntity(itemDTO));
        return itemDTO;
    }
    @Override
    public List<ItemDTO> getAll(){
        List<Item> listaItem = itemRepository.findAll();
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for(Item item : listaItem){
            itemDTOS.add(itemMapper.mapToDto(item));
        }
        return itemDTOS;
    }

    @Override
    public ItemDTO getItembyProyectoId(Long id) throws ItemException {
        Optional<Item> item = itemRepository.findByIdProyecto(id);
        if (item.isPresent()) {
            return itemMapper.mapToDto(item.get());
        } else {
            throw new ItemException("notFound", "No se encontraron los item del proyecto");
        }
    }



}
