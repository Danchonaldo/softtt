package soft.lab9.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soft.lab9.dto.ItemDTO;
import soft.lab9.services.ItemServiceInterface;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class RestController {

    private final ItemServiceInterface itemService;

    @GetMapping
    public List<ItemDTO> getItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemDTO getItem(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public ItemDTO addItem(@RequestBody ItemDTO itemDto) {
        return itemService.createItem(itemDto);
    }
}
