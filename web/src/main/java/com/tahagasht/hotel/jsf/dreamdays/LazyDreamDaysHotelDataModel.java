package com.tahagasht.hotel.jsf.dreamdays;

import com.tahagasht.hotel.ejb.dto.DreamDaysCityDto;
import com.tahagasht.hotel.ejb.dto.DreamDaysHotelDto;
import com.tahagasht.hotel.ejb.service.DreamDaysCityService;
import com.tahagasht.hotel.ejb.service.DreamDaysHotelService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyDreamDaysHotelDataModel extends LazyDataModel<DreamDaysHotelDto> {

    private DreamDaysHotelService datasource;

    public LazyDreamDaysHotelDataModel(DreamDaysHotelService dreamDaysHotelService) {
        this.datasource = dreamDaysHotelService;
    }

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
    public DreamDaysHotelDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findDreamDaysHotelById(Long.valueOf(rowKey));
        else
            return new DreamDaysHotelDto();
    }

    @Override
    public String getRowKey(DreamDaysHotelDto dreamDaysHotelDto) {
        return String.valueOf(dreamDaysHotelDto.getHotelId());
    }

    @Override
    public List<DreamDaysHotelDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
