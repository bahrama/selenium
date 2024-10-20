package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.HotelChanneleadDao;
import com.tahagasht.hotel.ejb.dto.HotelChanneleadDto;
import com.tahagasht.hotel.ejb.dto.HotelChanneleadDtoManager;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.HotelDtoManager;
import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelChannelead;
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
public class HotelChanneleadService {

    @Inject
    private HotelChanneleadDao hotelChanneleadDao;

    private HotelChanneleadDtoManager hotelChanneleadDtoManager = Mappers.getMapper(HotelChanneleadDtoManager .class);

    public int countHotel(){
        return hotelChanneleadDao.countHotel();
    }

    public HotelChanneleadDto findHotelChanneleadById(Long id) throws NoSuchElementException {
        try {
            return hotelChanneleadDtoManager.transferEntityToDto(hotelChanneleadDao.findHotelById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<HotelChanneleadDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<HotelChannelead> products = hotelChanneleadDao.search(offset,pageSize,sortBy,filterBy);
        List<HotelChanneleadDto> productDtos = new ArrayList<>();
        products.stream().forEach(i->{
            productDtos.add(hotelChanneleadDtoManager.transferEntityToDto(i));
        });
        return productDtos;
    }


}
