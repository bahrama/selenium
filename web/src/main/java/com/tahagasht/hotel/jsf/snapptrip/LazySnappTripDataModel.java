package com.tahagasht.hotel.jsf.snapptrip;

import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.SnappTripDto;
import com.tahagasht.hotel.ejb.service.SnappTripService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazySnappTripDataModel extends LazyDataModel<SnappTripDto> {
    private SnappTripService datasource;

    public LazySnappTripDataModel(SnappTripService snappTripService) {
        this.datasource = snappTripService;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        return datasource.countSnappTrip(filter);
    }
    @Override
    public SnappTripDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findSnappTripById(Long.valueOf(rowKey));
        else
            return new SnappTripDto();
    }

    @Override
    public String getRowKey(SnappTripDto snappTripDto) {
        return String.valueOf(snappTripDto.getHotelCode());
    }

    @Override
    public List<SnappTripDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
