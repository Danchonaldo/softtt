package soft.lab9.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.lab9.dto.CountryDTO;
import soft.lab9.entity.Country;
import soft.lab9.mappers.CountryMapper;
import soft.lab9.repositories.CountryRepository;
import soft.lab9.services.CountryServiceInterface;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements CountryServiceInterface {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    @Override
    public List<CountryDTO> getAllCountries() {
        return countryMapper.toDtoList(countryRepository.findAll());
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        return countryMapper.toDto(countryRepository.findById(id).orElse(null));
    }

    @Override
    public CountryDTO addCountry(CountryDTO countryDTO) {
        Country country = countryMapper.toEntity(countryDTO);
        return countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public CountryDTO updateCountry(CountryDTO countryDTO) {
        Country country = countryMapper.toEntity(countryDTO);
        if (country.getId() != null) {
            return countryMapper.toDto(countryRepository.save(country));
        }
        return null;
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

}
