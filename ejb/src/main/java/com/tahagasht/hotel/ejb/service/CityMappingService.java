package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.CityMappingDao;
import com.tahagasht.hotel.ejb.dto.*;
import com.tahagasht.hotel.ejb.model.CityMapping;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

@Stateless
@LocalBean
public class CityMappingService {
    @Inject
    private CityMappingDao cityMappingDao;

    private CityMappingDtoManager cityMappingDtoManager = Mappers.getMapper(CityMappingDtoManager.class);

    public CityMapping findCityMappingByHotelCodeAndSupplierId(String cityCode, Long supplierId) throws Exception {
        return cityMappingDao.findCityMappingByHotelCodeAndSupplierId(cityCode,supplierId).get();
    }

    public void save(CityMappingDto cityMappingDto) throws Exception {
        CityMapping cityMapping = cityMappingDtoManager.transferDtoToEntity(cityMappingDto);
        cityMappingDao.save(cityMapping);
    }

}
