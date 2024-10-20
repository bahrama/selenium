package com.tahagasht.hotel.jsf.city;

import com.tahagasht.hotel.ejb.dto.CityDto;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.service.CityService;
import com.tahagasht.hotel.ejb.service.HotelService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyCityDataModel  extends LazyDataModel<CityDto> {

    private CityService datasource;

    public LazyCityDataModel(CityService cityService) {
        this.datasource = cityService;
    }
    @Override
    public int count(Map<String, FilterMeta> map) {
        return datasource.countCity();
    }

    @Override
    public CityDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findCityById(Long.valueOf(rowKey));
        else
            return new CityDto();
    }

    @Override
    public String getRowKey(CityDto cityDto) {
        return String.valueOf(cityDto.getId());
    }

    @Override
    public List<CityDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
