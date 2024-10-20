package com.tahagasht.hotel.jsf.channelead;

import com.tahagasht.hotel.ejb.dto.HotelChanneleadDto;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.service.HotelChanneleadService;
import com.tahagasht.hotel.ejb.service.HotelService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyHotelChanneleadDataModel extends LazyDataModel<HotelChanneleadDto> {

    private HotelChanneleadService datasource;

    public LazyHotelChanneleadDataModel(HotelChanneleadService hotelChanneleadService) {
        this.datasource = hotelChanneleadService;
    }
    @Override
    public int count(Map<String, FilterMeta> map) {
        return datasource.countHotel();
    }

    @Override
    public HotelChanneleadDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findHotelChanneleadById(Long.valueOf(rowKey));
        else
            return new HotelChanneleadDto();
    }

    @Override
    public String getRowKey(HotelChanneleadDto hotelChanneleadDto) {
        return String.valueOf(hotelChanneleadDto.getId());
    }

    @Override
    public List<HotelChanneleadDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
