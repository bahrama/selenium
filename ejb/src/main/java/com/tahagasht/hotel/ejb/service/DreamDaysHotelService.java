package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.DreamDaysHotelDao;
import com.tahagasht.hotel.ejb.dao.HotelChanneleadDao;
import com.tahagasht.hotel.ejb.dto.DreamDaysHotelDto;
import com.tahagasht.hotel.ejb.dto.DreamDaysHotelDtoManager;
import com.tahagasht.hotel.ejb.dto.HotelChanneleadDto;
import com.tahagasht.hotel.ejb.dto.HotelChanneleadDtoManager;
import com.tahagasht.hotel.ejb.model.DreamdaysHotel;
import com.tahagasht.hotel.ejb.model.HotelChannelead;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@LocalBean
@Stateless
public class DreamDaysHotelService {
    @Inject
    private DreamDaysHotelDao dreamDaysHotelDao;

    private DreamDaysHotelDtoManager dreamDaysHotelDtoManager = Mappers.getMapper(DreamDaysHotelDtoManager .class);

    public int countHotel(Map<String, String> filterBy){
        return dreamDaysHotelDao.countDreamDaysHotel(filterBy);
    }

    public DreamDaysHotelDto findDreamDaysHotelById(Long id) throws NoSuchElementException {
        try {
            return dreamDaysHotelDtoManager.transferEntityToDto(dreamDaysHotelDao.findHotelById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<DreamDaysHotelDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<DreamdaysHotel> dreamdaysHotels = dreamDaysHotelDao.search(offset,pageSize,sortBy,filterBy);
        List<DreamDaysHotelDto> dreamDaysHotelDtos = new ArrayList<>();
        dreamdaysHotels.stream().forEach(i->{
            dreamDaysHotelDtos.add(dreamDaysHotelDtoManager.transferEntityToDto(i));
        });
        return dreamDaysHotelDtos;
    }

}
