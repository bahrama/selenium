package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.HotelMapping;
import com.tahagasht.hotel.ejb.model.SnappTrip;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface SnappTripDtoManager {

    @Mapping(source = "hotelCode" , target = "hotelCode")
    @Mapping(source = "nothing" , target = "nothing")
    @Mapping(source = "hotelName" , target = "hotelName")
    @Mapping(source = "hotelType" , target = "hotelType")
    @Mapping(source = "cityCode" , target = "cityCode")
    @Mapping(source = "cityName" , target = "cityName")
    SnappTripDto transferToDto(SnappTrip snappTrip);

    @InheritInverseConfiguration
    SnappTrip transferDtoToEntity(SnappTripDto snappTripDto);
}
