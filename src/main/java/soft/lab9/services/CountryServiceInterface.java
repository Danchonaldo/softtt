package soft.lab9.services;

import soft.lab9.dto.CountryDTO;

import java.util.List;

public interface CountryServiceInterface {
    List<CountryDTO> getAllCountries();
    CountryDTO getCountryById(Long id);
    CountryDTO addCountry(CountryDTO countryDTO);
    CountryDTO updateCountry(CountryDTO countryDTO);
    void deleteCountry(Long id);
}
