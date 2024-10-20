package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.Hotel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface HotelDtoManager {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "addresses" , target = "addresses")
    @Mapping(source = "airports" , target = "airports")
    @Mapping(source = "autofillText" , target = "autofillText")
    @Mapping(source = "cityName" , target = "cityName")
    @Mapping(source = "comment" , target = "comment")
    @Mapping(source = "countryCode" , target = "countryCode")
    @Mapping(source = "destinationId" , target = "destinationId")
    @Mapping(source = "destinationName" , target = "destinationName")
    @Mapping(source = "geoAccuracy" , target = "geoAccuracy")
    @Mapping(source = "giataCode" , target = "giataCode")
    @Mapping(source = "lastUpdate" , target = "lastUpdate")
    @Mapping(source = "latitude" , target = "latitude")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "persianAddresses" , target = "persianAddresses")
    @Mapping(source = "persianCityName" , target = "persianCityName")
    @Mapping(source = "persianName" , target = "persianName")
    @Mapping(source = "phones" , target = "phones")
    @Mapping(source = "pictureUrl" , target = "pictureUrl")
    @Mapping(source = "postalCode" , target = "postalCode")
    @Mapping(source = "rating" , target = "rating")
    @Mapping(source = "urls" , target = "urls")
    @Mapping(source = "vendor" , target = "vendor")
    @Mapping(source = "agency" , target = "agency")
    @Mapping(source = "city" , target = "city")
    @Mapping(source = "country" , target = "country")
    @Mapping(source = "currency" , target = "currency")
    @Mapping(source = "hotelchain" , target = "hotelchain")
    @Mapping(source = "picture" , target = "picture")
    HotelDto transferHotelToDto(Hotel hotel);

    @InheritInverseConfiguration
    Hotel transferHotelDtoToEntity(HotelDto hotelDto);
}
