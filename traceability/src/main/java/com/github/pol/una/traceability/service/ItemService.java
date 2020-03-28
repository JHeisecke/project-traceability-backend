package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.ItemDTO;
import com.github.pol.una.traceability.exceptions.ItemException;

import java.util.List;

/**
 * @author yedaloc
 */
public interface ItemService {

    List<ItemDTO> getItemsByProyectoId(Long id) throws ItemException;

    ItemDTO saveItem(ItemDTO itemDTO) throws ItemException;

    void deleteItem(Long id) throws ItemException;
}
