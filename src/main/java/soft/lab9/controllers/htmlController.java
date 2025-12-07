package soft.lab9.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import soft.lab9.services.ItemServiceInterface;

@Controller
@RequiredArgsConstructor
public class htmlController {
    private final ItemServiceInterface itemService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "index";
    }

}
