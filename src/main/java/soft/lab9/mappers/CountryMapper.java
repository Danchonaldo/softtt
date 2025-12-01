package soft.lab9.mappers;


import org.mapstruct.Mapper;
import soft.lab9.dto.CountryDTO;
import soft.lab9.entity.Country;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDTO toDto(Country country);
    Country toEntity(CountryDTO countryDTO);
    List<CountryDTO> toDtoList(List<Country> countries);
}