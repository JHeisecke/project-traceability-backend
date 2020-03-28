package com.github.pol.una.traceability.mapper.impl;
import com.github.pol.una.traceability.dto.ItemDTO;
import com.github.pol.una.traceability.entities.Item;
import com.github.pol.una.traceability.mapper.BaseMapper;
import com.github.pol.una.traceability.mapper.OrikaBeanMapper;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * @author yedaloc
 */
@Component
public class ItemMapper implements BaseMapper<Item, ItemDTO> {

    private final OrikaBeanMapper mapper;

    public ItemMapper(OrikaBeanMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<ItemDTO> mapAsList(List<Item> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO mapToDto(Item entity) {
        return mapper.map(entity, ItemDTO.class);
    }

    @Override
    public Item mapToEntity(ItemDTO dto) {
        return mapper.map(dto, Item.class);
    }

    @Override
    public MapperFacade getMapper() {
        return mapper;
    }

}
