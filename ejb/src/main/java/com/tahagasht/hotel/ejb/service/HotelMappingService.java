package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.HotelMappingDao;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.HotelDtoManager;
import com.tahagasht.hotel.ejb.dto.HotelMappingDto;
import com.tahagasht.hotel.ejb.dto.HotelMappingDtoManager;
import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Stateless
@LocalBean
public class HotelMappingService {

    @Inject
    private HotelMappingDao hotelMappingDao;

    private HotelMappingDtoManager hotelMappingDtoManager = Mappers.getMapper(HotelMappingDtoManager.class);

    public void save(HotelMappingDto hotelMappingDto) throws Exception {
        HotelMapping hotelMapping = hotelMappingDtoManager.transferDtoToEntity(hotelMappingDto);
        hotelMappingDao.save(hotelMapping);
    }

    public HotelMapping findHotelMappingByHotelCodeAndSupplierId(String hotelCode, Long supplierId) throws Exception {
       return hotelMappingDao.findHotelMappingByHotelCodeAndSupplierId(hotelCode,supplierId).get();
    }
}
