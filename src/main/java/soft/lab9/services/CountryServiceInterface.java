package soft.lab9.services;

import soft.lab9.dto.CountryDTO;

import java.util.List;

public interface CountryServiceInterface {
    List<CountryDTO> getAllCountries();
    CountryDTO getCountryById(Long id);
    CountryDTO createCountry(CountryDTO countryDTO);
    CountryDTO updateCountry(Long id, CountryDTO countryDto);
    boolean deleteCountry(Long id);
}
