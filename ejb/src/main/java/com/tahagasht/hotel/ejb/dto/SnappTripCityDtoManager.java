package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.SnappTrip;
import com.tahagasht.hotel.ejb.model.SnappTripCity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface SnappTripCityDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "title" , target = "title")
    @Mapping(source = "description" , target = "description")
    @Mapping(source = "stateId" , target = "stateId")
    @Mapping(source = "stateTitle" , target = "stateTitle")
    SnappTripCityDto transferToDto(SnappTripCity snappTripCity);

    @InheritInverseConfiguration
    SnappTripCity transferDtoToEntity(SnappTripCityDto snappTripCityDto);


}
