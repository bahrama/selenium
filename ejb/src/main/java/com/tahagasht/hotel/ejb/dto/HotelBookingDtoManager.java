package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.HotelBooking;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface HotelBookingDtoManager {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "hotelName" , target = "hotelName")
    @Mapping(source = "ficility" , target = "ficility")
    @Mapping(source = "description" , target = "description")
    @Mapping(source = "cityName" , target = "cityName")
    @Mapping(source = "countryCode" , target = "countryCode")
    HotelBookingDto transferEntityToDto(HotelBooking hotelBooking);

    @InheritInverseConfiguration
    HotelBooking transferDtoToEntity(HotelBookingDto hotelBookingDto);
}
