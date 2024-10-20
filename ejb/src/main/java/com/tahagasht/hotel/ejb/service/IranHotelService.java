package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.IranHotelDao;
import com.tahagasht.hotel.ejb.dto.IranHotelDto;
import com.tahagasht.hotel.ejb.dto.IranHotelDtoManager;
import com.tahagasht.hotel.ejb.dto.SnappTripDto;
import com.tahagasht.hotel.ejb.dto.SnappTripDtoManager;
import com.tahagasht.hotel.ejb.model.IranHotel;
import com.tahagasht.hotel.ejb.model.SnappTrip;
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
public class IranHotelService {
    @Inject
    private IranHotelDao iranHotelDao;

    private IranHotelDtoManager iranHotelDtoManager = Mappers.getMapper(IranHotelDtoManager.class);

    public int countIranHotel(Map<String, String> filterBy){
        return iranHotelDao.countIranHotel(filterBy);
    }

    public IranHotelDto findIranHotelById(Long id) throws NoSuchElementException {
        try {
            return iranHotelDtoManager.transferToDto(iranHotelDao.findIranHotelById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<IranHotelDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<IranHotel> iranHotels = iranHotelDao.search(offset,pageSize,sortBy,filterBy);
        List<IranHotelDto> iranHotelDtos = new ArrayList<>();
        iranHotels.stream().forEach(i->{
            iranHotelDtos.add(iranHotelDtoManager.transferToDto(i));
        });
        return iranHotelDtos;
    }




}
