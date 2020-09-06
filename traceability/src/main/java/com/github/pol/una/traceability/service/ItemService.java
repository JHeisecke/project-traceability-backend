package com.github.pol.una.traceability.service;

import com.github.pol.una.traceability.dto.ItemDTO;
import com.github.pol.una.traceability.exceptions.ItemException;

import java.util.List;

/**
 * @author yedaloc
 */
public interface ItemService {

    List<ItemDTO> getItemsByProyectoId(Long id) throws ItemException;

    ItemDTO saveItem(ItemDTO itemDTO);

    void deleteItem(Long id) throws ItemException;

    List<ItemDTO> getItemsByLineaBase(Long idLineaBase) throws ItemException;

    List<ItemDTO> getItemsByProyectoAndFase(Long idProyecto, Long idFase);

    List<ItemDTO> asignarLineaBase(Long idLineaBase, List<ItemDTO> items) throws ItemException;

    List<ItemDTO> getItemsByProyectoAndFaseAndLineaBaseNull(Long idProyecto, Long idFase);

}
