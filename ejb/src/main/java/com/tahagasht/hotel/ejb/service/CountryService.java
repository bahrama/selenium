package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.CountryDao;
import com.tahagasht.hotel.ejb.dto.CityDtoManager;
import com.tahagasht.hotel.ejb.dto.CountryDto;
import com.tahagasht.hotel.ejb.dto.CountryDtoManager;
import com.tahagasht.hotel.ejb.model.Country;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@LocalBean
@Stateless
public class CountryService {
    @Inject
    private CountryDao countryDao;

    private CountryDtoManager countryDtoManager = Mappers.getMapper(CountryDtoManager.class);

    public List<CountryDto> findAllCountry(){
        List<CountryDto> countryDtos = new ArrayList<>();
        countryDao.findAllCountry().forEach(c->{
            countryDtos.add(countryDtoManager.transferEntityToDto(c));
        });
        return countryDtos;
    }
}
