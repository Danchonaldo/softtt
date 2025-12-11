package soft.lab9.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.lab9.dto.ItemDTO;
import soft.lab9.entity.Country;
import soft.lab9.entity.Item;
import soft.lab9.mappers.CountryMapper;
import soft.lab9.mappers.ItemMapper;
import soft.lab9.repositories.CountryRepository;
import soft.lab9.repositories.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements soft.lab9.services.ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        List<ItemDTO> dtos = new ArrayList<>();
        for (Item item : items) {
            dtos.add(itemMapper.toDto(item));
        }
        return dtos;
    }

    @Override
    public ItemDTO getItemById(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            return itemMapper.toDto(item);
        }
        return null;
    }

    @Override
    public ItemDTO createItem(ItemDTO ItemDTO) {
        Item item = itemMapper.toEntity(ItemDTO);

        if(ItemDTO.getManufacturer() != null && ItemDTO.getManufacturer().getId() != null){
            Country manufacturer = countryRepository.findById(ItemDTO.getManufacturer().getId()).orElse(null);
            item.setManufacturer(manufacturer);
        }

        Item saved = itemRepository.save(item);
        return itemMapper.toDto(saved);
    }

    @Override
    public ItemDTO updateItem(Long id, ItemDTO ItemDTO) {
        Item check = itemRepository.findById(id).orElse(null);
        if (check != null) {
            check.setName(ItemDTO.getName());
            check.setPrice(ItemDTO.getPrice());
            check.setQuantity(ItemDTO.getQuantity());

            if(ItemDTO.getManufacturer() != null && ItemDTO.getManufacturer().getId() != null){
                Country manufacturer = countryRepository.findById(ItemDTO.getManufacturer().getId()).orElse(null);
                check.setManufacturer(manufacturer);
            }

            Item saved = itemRepository.save(check);
            return itemMapper.toDto(saved);
        }
        return null;
    }

    @Override
    public boolean deleteItem(Long id) {
        Item check = itemRepository.findById(id).orElse(null);
        if (check != null) {
            itemRepository.delete(check);
            return true;
        }
        return false;
    }

}