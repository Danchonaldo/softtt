package soft.lab9.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.lab9.dto.CountryDTO;
import soft.lab9.entity.Country;
import soft.lab9.mappers.CountryMapper;
import soft.lab9.repositories.CountryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements soft.lab9.services.CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        List<CountryDTO> dtos = new ArrayList<>();
        for (Country country : countries) {
            dtos.add(countryMapper.toDto(country));
        }
        return dtos;
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        Country country = countryRepository.findById(id).orElse(null);
        if (country != null) {
            return countryMapper.toDto(country);
        }
        return null;
    }

    @Override
    public CountryDTO createCountry(CountryDTO countryDto) {
        Country country = countryMapper.toEntity(countryDto);
        Country saved = countryRepository.save(country);
        return countryMapper.toDto(saved);
    }

    @Override
    public CountryDTO updateCountry(Long id, CountryDTO countryDto) {
        Country check = countryRepository.findById(id).orElse(null);
        if (check != null) {
            check.setName(countryDto.getName());
            check.setCode(countryDto.getCode());
            Country saved = countryRepository.save(check);
            return countryMapper.toDto(saved);
        }
        return null;
    }

    @Override
    public boolean deleteCountry(Long id) {
        Country check = countryRepository.findById(id).orElse(null);
        if (check != null) {
            countryRepository.delete(check);
            return true;
        }
        return false;
    }
}
