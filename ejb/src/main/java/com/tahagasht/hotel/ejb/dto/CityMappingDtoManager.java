package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.City;
import com.tahagasht.hotel.ejb.model.CityMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CityMappingDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "supplierCity" , target = "supplierCity")
    @Mapping(source = "city" , target = "city")
    @Mapping(source = "supplier" , target = "supplier")
    CityMappingDto transferEntityToDto(CityMapping cityMapping);

    @InheritInverseConfiguration
    CityMapping transferDtoToEntity(CityMappingDto cityMappingDto);
}
