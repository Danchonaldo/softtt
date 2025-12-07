package soft.lab9.services;

import soft.lab9.dto.ItemDTO;

import java.util.List;

public interface ItemServiceInterface {
    List<ItemDTO> getAllItems();
    ItemDTO getItemById(Long id);
    ItemDTO createItem(ItemDTO itemDto);
    ItemDTO updateItem(Long id,ItemDTO itemDto);
    boolean deleteItem(Long id);
}
