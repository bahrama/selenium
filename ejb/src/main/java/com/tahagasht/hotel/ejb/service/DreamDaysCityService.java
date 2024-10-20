package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.DreamDaysCityDao;
import com.tahagasht.hotel.ejb.dto.CullucCityDto;
import com.tahagasht.hotel.ejb.dto.CullucCityDtoManager;
import com.tahagasht.hotel.ejb.dto.DreamDaysCityDto;
import com.tahagasht.hotel.ejb.dto.DreamDaysCityDtoManager;
import com.tahagasht.hotel.ejb.model.CullucCity;
import com.tahagasht.hotel.ejb.model.DreamdaysCity;
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
public class DreamDaysCityService {

    @Inject
    private DreamDaysCityDao dreamDaysCityDao;

    private DreamDaysCityDtoManager dreamDaysCityDtoManager = Mappers.getMapper(DreamDaysCityDtoManager.class);

    public int countDreamDaysCity(){
        return dreamDaysCityDao.countDreamDaysCity();
    }

    public DreamDaysCityDto findDreamDaysCityById(Long id) throws NoSuchElementException {
        try {
            return dreamDaysCityDtoManager.transferEntityToDto(dreamDaysCityDao.findDreamDaysCityById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<DreamDaysCityDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<DreamdaysCity> dreamdaysCities = dreamDaysCityDao.search(offset,pageSize,sortBy,filterBy);
        List<DreamDaysCityDto> cityDtos = new ArrayList<>();
        dreamdaysCities.stream().forEach(i->{
            cityDtos.add(dreamDaysCityDtoManager.transferEntityToDto(i));
        });
        return cityDtos;
    }
}
