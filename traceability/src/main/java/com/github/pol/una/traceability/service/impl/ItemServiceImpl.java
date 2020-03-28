package com.github.pol.una.traceability.service.impl;

import com.github.pol.una.traceability.dto.ItemDTO;
import com.github.pol.una.traceability.dto.RolDTO;
import com.github.pol.una.traceability.entities.Item;
import com.github.pol.una.traceability.entities.Proyecto;
import com.github.pol.una.traceability.entities.Rol;
import com.github.pol.una.traceability.exceptions.ItemException;
import com.github.pol.una.traceability.exceptions.ProjectException;
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
        itemRepository.save(itemMapper.mapToEntity(itemDTO));
        return itemDTO;
    }

    @Override
    public void deleteItem(Long id) throws ItemException {
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()) {
            itemRepository.delete(item.get());
        } else {
            throw new ItemException("notFound", "No se encontró el item "+id);
        }
    }

    @Override
    public List<ItemDTO> getItemsByProyectoId(Long id) throws ItemException {
        List<Item> items = itemRepository.findByIdProyecto(id);
        List<ItemDTO> itemDTOs = new ArrayList<>();
        if (items != null) {
            for(Item item : items){
                itemDTOs.add(itemMapper.mapToDto(item));
            }
            return itemDTOs;
        } else {
            throw new ItemException("notFound", "Este proyecto no tiene items");
        }
    }



}
