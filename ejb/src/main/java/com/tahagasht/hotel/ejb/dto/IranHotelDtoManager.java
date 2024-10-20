package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.IranHotel;
import com.tahagasht.hotel.ejb.model.SnappTripCity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface IranHotelDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "pictureUrl" , target = "pictureUrl")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "cityName" , target = "cityName")
    @Mapping(source = "typeName" , target = "typeName")
    @Mapping(source = "gradeName" , target = "gradeName")
    @Mapping(source = "chainName" , target = "chainName")
    @Mapping(source = "stateName" , target = "stateName")
    @Mapping(source = "address" , target = "address")
    @Mapping(source = "hotelRank" , target = "hotelRank")
    @Mapping(source = "rankName" , target = "rankName")
    @Mapping(source = "cityId" , target = "cityId")
    @Mapping(source = "stateId" , target = "stateId")
    @Mapping(source = "hasFreeTransfer" , target = "hasFreeTransfer")
    IranHotelDto transferToDto(IranHotel iranHotel);

    @InheritInverseConfiguration
    IranHotel transferDtoToEntity(IranHotelDto iranHotelDto);
}
