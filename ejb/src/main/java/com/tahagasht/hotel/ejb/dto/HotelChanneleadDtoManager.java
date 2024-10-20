package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.HotelBooking;
import com.tahagasht.hotel.ejb.model.HotelChannelead;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface HotelChanneleadDtoManager {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "cityId" , target = "cityId")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "nameEn" , target = "nameEn")
    @Mapping(source = "neighbourhood" , target = "neighbourhood")
    @Mapping(source = "cityCode" , target = "cityCode")
    @Mapping(source = "cityName" , target = "cityName")
    @Mapping(source = "address1" , target = "address1")
    @Mapping(source = "address2" , target = "address2")
    @Mapping(source = "location" , target = "location")
    @Mapping(source = "imageUrl" , target = "imageUrl")
    HotelChanneleadDto transferEntityToDto(HotelChannelead hotelChannelead);

    @InheritInverseConfiguration
    HotelChannelead transferDtoToEntity(HotelChanneleadDto hotelChanneleadDto);
}
