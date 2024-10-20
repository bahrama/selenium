package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface HotelMappingDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "cityCode" , target = "cityCode")
    @Mapping(source = "countryCode" , target = "countryCode")
    @Mapping(source = "giataCode" , target = "giataCode")
    @Mapping(source = "hotelCode" , target = "hotelCode")
    @Mapping(source = "providerName" , target = "providerName")
    @Mapping(source = "providerType" , target = "providerType")
    @Mapping(source = "supplier" , target = "supplier")
    HotelMappingDto transferToDto(HotelMapping hotelMapping);

    @InheritInverseConfiguration
    HotelMapping transferDtoToEntity(HotelMappingDto hotelMappingDto);
}
