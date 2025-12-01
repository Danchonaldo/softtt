package soft.lab9.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soft.lab9.dto.ItemDTO;
import soft.lab9.services.impl.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemRestController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDTO> getItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemDTO getItem(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO) {
        return itemService.addItem(itemDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
