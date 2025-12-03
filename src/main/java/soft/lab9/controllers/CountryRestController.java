package soft.lab9.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soft.lab9.dto.CountryDTO;
import soft.lab9.services.CountryServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryRestController {

    private final CountryServiceInterface countryService;

    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountryDTO getCountry(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public CountryDTO addCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.addCountry(countryDTO);
    }

    @PutMapping
    public CountryDTO updateCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.updateCountry(countryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
