package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.CityDao;
import com.tahagasht.hotel.ejb.dto.CityDto;
import com.tahagasht.hotel.ejb.dto.CityDtoManager;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.HotelDtoManager;
import com.tahagasht.hotel.ejb.model.City;
import com.tahagasht.hotel.ejb.model.Hotel;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@LocalBean
@Stateless
public class CityService {
    @Inject
    private CityDao cityDao;

    private CityDtoManager cityDtoManager = Mappers.getMapper(CityDtoManager.class);

    public void save(CityDto cityDto) throws Exception {
        City city = cityDtoManager.transferDtoToEntity(cityDto);
        cityDao.save(city);
    }

    public int countCity(){
        return cityDao.countCity();
    }

    public List<CityDto> findAllCity(String countryCode){
        List<CityDto> cityDtos = new ArrayList<>();
        cityDao.findAllCity(countryCode).forEach(c->{
            cityDtos.add(cityDtoManager.transferEntityToDto(c));
        });
        return cityDtos;
    }


    public CityDto findCityById(Long id) {
        try {
            return cityDtoManager.transferEntityToDto(cityDao.findCityById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<CityDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<City> cities = cityDao.search(offset,pageSize,sortBy,filterBy);
        List<CityDto> cityDtos = new ArrayList<>();
        cities.stream().forEach(i->{
            cityDtos.add(cityDtoManager.transferEntityToDto(i));
        });
        return cityDtos;
    }
}
