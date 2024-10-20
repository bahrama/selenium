package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.CullucCityDao;
import com.tahagasht.hotel.ejb.dto.CullucCityDto;
import com.tahagasht.hotel.ejb.dto.CullucCityDtoManager;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.HotelDtoManager;
import com.tahagasht.hotel.ejb.model.CullucCity;
import com.tahagasht.hotel.ejb.model.Hotel;
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
public class CullucCityService {

    @Inject
    private CullucCityDao cullucCityDao;

    private CullucCityDtoManager cullucCityDtoManager = Mappers.getMapper(CullucCityDtoManager.class);

    public int countCullucCity(Map<String, String> filterBy){
        return cullucCityDao.countCullucCity(filterBy);
    }

    public CullucCityDto findCullucCityById(Long id) throws NoSuchElementException {
        try {
            return cullucCityDtoManager.transferEntityToDto(cullucCityDao.findCullucCityById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<CullucCityDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<CullucCity> cullucCities = cullucCityDao.search(offset,pageSize,sortBy,filterBy);
        List<CullucCityDto> cityDtos = new ArrayList<>();
        cullucCities.stream().forEach(i->{
            cityDtos.add(cullucCityDtoManager.transferEntityToDto(i));
        });
        return cityDtos;
    }
}
