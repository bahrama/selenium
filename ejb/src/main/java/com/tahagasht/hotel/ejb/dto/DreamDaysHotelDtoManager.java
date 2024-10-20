package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.DreamdaysCity;
import com.tahagasht.hotel.ejb.model.DreamdaysHotel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface DreamDaysHotelDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "hotelId" , target = "hotelId")
    @Mapping(source = "hotelName" , target = "hotelName")
    @Mapping(source = "latitude" , target = "latitude")
    @Mapping(source = "longitude" , target = "longitude")
    @Mapping(source = "address" , target = "address")
    @Mapping(source = "rating" , target = "rating")
    @Mapping(source = "countryId" , target = "countryId")
    @Mapping(source = "countryName" , target = "countryName")
    @Mapping(source = "cityId" , target = "cityId")
    @Mapping(source = "cityName" , target = "cityName")
    @Mapping(source = "giataId" , target = "giataId")
    @Mapping(source = "hotelFrontImage" , target = "hotelFrontImage")
    @Mapping(source = "isRecomondedHotel" , target = "isRecomondedHotel")
    @Mapping(source = "isActive" , target = "isActive")
    @Mapping(source = "updatedDate" , target = "updatedDate")
    DreamDaysHotelDto transferEntityToDto(DreamdaysHotel dreamdaysHotel);

    @InheritInverseConfiguration
    DreamdaysHotel transferDtoToEntity(DreamDaysHotelDto dreamDaysHotelDto);
}
