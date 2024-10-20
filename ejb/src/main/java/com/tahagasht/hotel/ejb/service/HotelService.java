package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.HotelDao;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.HotelDtoManager;
import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelBooking;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Stateless
@LocalBean
public class HotelService {

    @Inject
    private HotelDao hotelDao;


    private HotelDtoManager hotelDtoManager = Mappers.getMapper(HotelDtoManager.class);
    public int countHotel(Map<String, String> filterBy){
        return hotelDao.countHotel(filterBy);
    }

    public HotelDto findHotelById(Long id) throws NoSuchElementException {
        try {
            return hotelDtoManager.transferHotelToDto(hotelDao.findHotelById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public void save(HotelDto hotelDto) throws Exception {
        Hotel hotel = hotelDtoManager.transferHotelDtoToEntity(hotelDto);
        hotelDao.save(hotel);
    }


    public List<HotelDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<Hotel> products = hotelDao.search(offset,pageSize,sortBy,filterBy);
        List<HotelDto> productDtos = new ArrayList<>();
        products.stream().forEach(i->{
            productDtos.add(hotelDtoManager.transferHotelToDto(i));
        });
        return productDtos;
    }

    public List<Tuple> findHotelByNameOrLatAndLng(String hotelName,double lat,double lng){
       return hotelDao.findHotelByNameOrLatAndLng(hotelName,lat,lng);
    }

}
