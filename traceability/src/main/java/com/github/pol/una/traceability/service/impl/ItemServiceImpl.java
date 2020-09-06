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
        if (itemDTO.getId() != null) {
            if (itemDTO.getIdLineaBase() != null) {
                throw new ItemException("com.github.pol.una.traceability.service.item.blockedItem",
                        "El item con id " + itemDTO.getId() +
                                "no se puede editar. Es parte de la linea base con id " +
                                itemDTO.getIdLineaBase());
            } else {
                itemDTO.setVersion(itemDTO.getVersion() + 1L);
                itemDTO.setFechaModificacion(new Date());
            }
        } else {
            itemDTO.setFechaAlta(new Date());
        }
        itemRepository.save(itemMapper.mapToEntity(itemDTO));
        return itemDTO;
    }

    @Override
    public void deleteItem(Long id) throws ItemException {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            itemRepository.delete(item.get());
        } else {
            throw new ItemException("notFound", "No se encontró el item " + id);
        }
    }

    @Override
    public List<ItemDTO> getItemsByProyectoId(Long id) throws ItemException {
        List<Item> items = itemRepository.findByIdProyecto(id);
        List<ItemDTO> itemDTOs = new ArrayList<>();
        if (items != null) {
            for (Item item : items) {
                itemDTOs.add(itemMapper.mapToDto(item));
            }
            return itemDTOs;
        } else {
            throw new ItemException("notFound", "Este proyecto no tiene items");
        }
    }

    @Override
    public List<ItemDTO> getItemsByLineaBase(Long idLineaBase) throws ItemException {
        List<Item> items = itemRepository.findByIdLineaBase(idLineaBase);
        List<ItemDTO> itemDTOs = new ArrayList<>();
        if (items != null) {
            for (Item item : items) {
                itemDTOs.add(itemMapper.mapToDto(item));
            }
            return itemDTOs;
        } else {
            throw new ItemException("notFound", "Este proyecto no tiene items");
        }
    }

    @Override
    public List<ItemDTO> getItemsByProyectoAndFase(Long idProyecto, Long idFase) {
        return itemMapper.mapAsList(
                itemRepository.findByIdProyectoAndIdFase(idProyecto, idFase));
    }

    @Override
    public List<ItemDTO> asignarLineaBase(Long idLineaBase, List<ItemDTO> items)
            throws ItemException {
        List<ItemDTO> result = new ArrayList<>();
        for (ItemDTO dtoRecibido : items) {
            Optional<Item> dtoId = itemRepository.findById(dtoRecibido.getId());
            if (dtoId.isPresent()) {
                ItemDTO dto = itemMapper.mapToDto(dtoId.get());
                dto.setIdLineaBase(idLineaBase);
                result.add(saveItem(dto));
            } else {
                throw new ItemException("com.github.pol.una.traceability.service.item", "No existe el item con id " + dtoRecibido.getId());
            }
        }
        return result;
    }

    @Override
    public List<ItemDTO> getItemsByProyectoAndFaseAndLineaBaseNull(
            Long idProyecto, Long idFase) {
        return itemMapper.mapAsList(itemRepository
                .findByIdProyectoAndIdFaseAndIdLineaBaseIsNull(idProyecto, idFase)
        );
    }

    @Override
    public ItemDTO getLastItemOfFase(Long idFase) throws ItemException {
        try {
            List<ItemDTO> itemsFase = itemMapper.mapAsList(itemRepository.findByIdFaseOrderByIdDesc(idFase));
            return itemsFase.get(0);
        } catch (Exception e) {
            throw new ItemException(e.getMessage(), "Uno de los parametros no se encontró");
        }
    }

    @Override
    public ItemDTO getItemById(Long id) throws ItemException {
        Optional<Item> item = itemRepository.findById(id);
        try {
            return itemMapper.mapToDto(item.get());
        } catch (Exception e){
            throw new ItemException("com.github.pol.una.traceability.notFound", "No se encontró el item");
        }
    }
}
