package com.tahagasht.hotel.jsf.hotel;

import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.service.HotelService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyHotelDataModel extends LazyDataModel<HotelDto> {

    private HotelService datasource;

    public LazyHotelDataModel(HotelService hotelService) {
        this.datasource = hotelService;
    }
/*    @Override
    public int count(Map<String, FilterMeta> map) {
        return datasource.countHotel(map);
    }*/

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        return datasource.countHotel(filter);
    }

    @Override
    public HotelDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findHotelById(Long.valueOf(rowKey));
        else
            return new HotelDto();
    }

    @Override
    public String getRowKey(HotelDto hotelDto) {
        return String.valueOf(hotelDto.getId());
    }

    @Override
    public List<HotelDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        Map<String,String> sort = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                sort.put(k,v.getOrder().name());
            });
        }
        return datasource.search(offset,pageSize,sort,filter);
    }
}
