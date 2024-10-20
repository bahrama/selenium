package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.SnappTripCityDao;
import com.tahagasht.hotel.ejb.dto.SnappTripCityDto;
import com.tahagasht.hotel.ejb.dto.SnappTripCityDtoManager;
import com.tahagasht.hotel.ejb.dto.SnappTripDto;
import com.tahagasht.hotel.ejb.dto.SnappTripDtoManager;
import com.tahagasht.hotel.ejb.model.SnappTrip;
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
public class SnappTripCityService {
    @Inject
    private SnappTripCityDao snappTripCityDao;

    private SnappTripCityDtoManager snappTripCityDtoManager = Mappers.getMapper(SnappTripCityDtoManager.class);

    public int countSnappTripCity(Map<String, String> filterBy){
        return snappTripCityDao.countSnappTripCity(filterBy);
    }

    public SnappTripCityDto findSnappTripCityById(Long id) throws NoSuchElementException {
        try {
            return snappTripCityDtoManager.transferToDto(snappTripCityDao.findSnappTripCityById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<SnappTripCityDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<SnappTripCity> snappTripCities = snappTripCityDao.search(offset,pageSize,sortBy,filterBy);
        List<SnappTripCityDto> snappTripDtoList = new ArrayList<>();
        snappTripCities.stream().forEach(i->{
            snappTripDtoList.add(snappTripCityDtoManager.transferToDto(i));
        });
        return snappTripDtoList;
    }
}
