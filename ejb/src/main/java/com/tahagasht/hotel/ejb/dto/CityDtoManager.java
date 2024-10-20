package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.City;
import com.tahagasht.hotel.ejb.model.HotelBooking;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CityDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "autofillText" , target = "autofillText")
    @Mapping(source = "cityIataCode" , target = "cityIataCode")
    @Mapping(source = "cityName" , target = "cityName")
    @Mapping(source = "cityPersianName" , target = "cityPersianName")
    @Mapping(source = "countryCode" , target = "countryCode")
    @Mapping(source = "countryName" , target = "countryName")
    @Mapping(source = "giataCode" , target = "giataCode")
    CityDto transferEntityToDto(City city);

    @InheritInverseConfiguration
    City transferDtoToEntity(CityDto cityDto);
}
