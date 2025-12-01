package soft.lab9.mappers;

import org.mapstruct.Mapper;
import soft.lab9.dto.ItemDTO;
import soft.lab9.entity.Item;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface ItemMapper {
    ItemDTO toDto(Item item);
    Item toEntity(ItemDTO itemDTO);
    List<ItemDTO> toDtoList(List<Item> items);
}
