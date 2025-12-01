package soft.lab9.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.lab9.dto.ItemDTO;
import soft.lab9.entity.Item;
import soft.lab9.mappers.ItemMapper;
import soft.lab9.repositories.ItemRepository;
import soft.lab9.services.ItemServiceInterface;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements ItemServiceInterface {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemDTO> getAllItems() {
        return itemMapper.toDtoList(itemRepository.findAll());
    }

    @Override
    public ItemDTO getItemById(Long id) {
        return itemMapper.toDto(itemRepository.findById(id).orElse(null));
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item = itemMapper.toEntity(itemDTO);
        return itemMapper.toDto(itemRepository.save(item));
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}