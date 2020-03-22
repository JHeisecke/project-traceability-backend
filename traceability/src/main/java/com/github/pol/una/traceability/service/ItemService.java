package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.ItemDTO;

import java.util.List;
/**
 * @author yedaloc
 */
public interface ItemService {

    List<ItemDTO> getAll();

    ItemDTO getItemByIdproject(Long id) ;

    ItemDTO saveProject(ItemDTO itemDTO);
}
