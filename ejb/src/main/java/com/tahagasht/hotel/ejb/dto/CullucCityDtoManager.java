package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.Country;
import com.tahagasht.hotel.ejb.model.CullucCity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CullucCityDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "cityName" , target = "cityName")
    @Mapping(source = "cityCode" , target = "cityCode")
    @Mapping(source = "countryName" , target = "countryName")
    @Mapping(source = "countryCode" , target = "countryCode")
    CullucCityDto transferEntityToDto(CullucCity cullucCity);

    @InheritInverseConfiguration
    CullucCity transferDtoToEntity(CullucCityDto cullucCityDto);
}
