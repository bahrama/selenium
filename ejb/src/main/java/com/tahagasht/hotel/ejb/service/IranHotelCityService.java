package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.IranHotelCityDao;
import com.tahagasht.hotel.ejb.dto.IranHotelCityDto;
import com.tahagasht.hotel.ejb.dto.IranHotelCityDtoManager;
import com.tahagasht.hotel.ejb.dto.SnappTripCityDto;
import com.tahagasht.hotel.ejb.dto.SnappTripCityDtoManager;
import com.tahagasht.hotel.ejb.model.IranHotelCity;
import com.tahagasht.hotel.ejb.model.SnappTripCity;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Stateless
@LocalBean
public class IranHotelCityService {
    @Inject
    private IranHotelCityDao iranHotelCityDao;

    private IranHotelCityDtoManager iranHotelCityDtoManager = Mappers.getMapper(IranHotelCityDtoManager.class);

    public int countIranHotelCity(Map<String, String> filterBy){
        return iranHotelCityDao.countIranHotelCity(filterBy);
    }

    public IranHotelCityDto findIranHotelCityById(Long id) throws NoSuchElementException {
        try {
            return iranHotelCityDtoManager.transferToDto(iranHotelCityDao.findIranHotelCityById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<IranHotelCityDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<IranHotelCity> iranHotelCities = iranHotelCityDao.search(offset,pageSize,sortBy,filterBy);
        List<IranHotelCityDto> iranHotelCityDtos = new ArrayList<>();
        iranHotelCities.stream().forEach(i->{
            iranHotelCityDtos.add(iranHotelCityDtoManager.transferToDto(i));
        });
        return iranHotelCityDtos;
    }
}
