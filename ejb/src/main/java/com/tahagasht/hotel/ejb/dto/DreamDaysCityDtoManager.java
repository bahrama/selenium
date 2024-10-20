package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.City;
import com.tahagasht.hotel.ejb.model.DreamdaysCity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface DreamDaysCityDtoManager {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "cityCode" , target = "cityCode")
    @Mapping(source = "cityName" , target = "cityName")
    DreamDaysCityDto transferEntityToDto(DreamdaysCity dreamdaysCity);

    @InheritInverseConfiguration
    DreamdaysCity transferDtoToEntity(DreamDaysCityDto dreamDaysCityDto);
}
