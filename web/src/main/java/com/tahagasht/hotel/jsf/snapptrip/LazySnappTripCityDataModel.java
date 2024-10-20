package com.tahagasht.hotel.jsf.snapptrip;

import com.tahagasht.hotel.ejb.dto.SnappTripCityDto;
import com.tahagasht.hotel.ejb.dto.SnappTripDto;
import com.tahagasht.hotel.ejb.service.SnappTripCityService;
import jakarta.faces.convert.Converter;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazySnappTripCityDataModel extends LazyDataModel<SnappTripCityDto> {
    private SnappTripCityService datasource;

    public LazySnappTripCityDataModel(SnappTripCityService snappTripCityService) {
        this.datasource = snappTripCityService;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        return datasource.countSnappTripCity(filter);
    }

    @Override
    public SnappTripCityDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findSnappTripCityById(Long.valueOf(rowKey));
        else
            return new SnappTripCityDto();
    }

    @Override
    public String getRowKey(SnappTripCityDto snappTripCityDto) {
        return String.valueOf(snappTripCityDto.getId());
    }

    @Override
    public List<SnappTripCityDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
