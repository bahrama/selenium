package com.tahagasht.hotel.ejb.service;

import com.tahagasht.hotel.ejb.dao.SnappTripDao;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.HotelDtoManager;
import com.tahagasht.hotel.ejb.dto.SnappTripDto;
import com.tahagasht.hotel.ejb.dto.SnappTripDtoManager;
import com.tahagasht.hotel.ejb.model.Hotel;
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
public class SnappTripService {
    @Inject
    private SnappTripDao snappTripDao;

    private SnappTripDtoManager snappTripDtoManager = Mappers.getMapper(SnappTripDtoManager.class);

    public int countSnappTrip(Map<String, String> filterBy){
        return snappTripDao.countSnappTrip(filterBy);
    }

    public SnappTripDto findSnappTripById(Long id) throws NoSuchElementException {
        try {
            return snappTripDtoManager.transferToDto(snappTripDao.findSnappTripById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    public List<SnappTripDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<SnappTrip> snappTrips = snappTripDao.search(offset,pageSize,sortBy,filterBy);
        List<SnappTripDto> snappTripDtos = new ArrayList<>();
        snappTrips.stream().forEach(i->{
            snappTripDtos.add(snappTripDtoManager.transferToDto(i));
        });
        return snappTripDtos;
    }


}
