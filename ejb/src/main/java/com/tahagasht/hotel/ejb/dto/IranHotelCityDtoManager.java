package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.IranHotelCity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "cdi")
public interface IranHotelCityDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "title" , target = "title")
    IranHotelCityDto transferToDto(IranHotelCity iranHotelCity);

    @InheritInverseConfiguration
    IranHotelCity transferDtoToEntity(IranHotelCityDto iranHotelCityDto);
}
