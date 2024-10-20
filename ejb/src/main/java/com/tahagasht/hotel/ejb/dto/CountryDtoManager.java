package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.City;
import com.tahagasht.hotel.ejb.model.Country;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CountryDtoManager {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "autofillText" , target = "autofillText")
    @Mapping(source = "countryCode" , target = "countryCode")
    @Mapping(source = "countryName" , target = "countryName")
    @Mapping(source = "countryPrefix" , target = "countryPrefix")
    @Mapping(source = "currencyCode" , target = "currencyCode")
    CountryDto transferEntityToDto(Country country);

    @InheritInverseConfiguration
    Country transferDtoToEntity(CountryDto countryDto);
}
