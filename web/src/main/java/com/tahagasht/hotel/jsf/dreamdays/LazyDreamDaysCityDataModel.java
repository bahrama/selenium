package com.tahagasht.hotel.jsf.dreamdays;

import com.tahagasht.hotel.ejb.dto.CullucCityDto;
import com.tahagasht.hotel.ejb.dto.DreamDaysCityDto;
import com.tahagasht.hotel.ejb.service.CullucCityService;
import com.tahagasht.hotel.ejb.service.DreamDaysCityService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyDreamDaysCityDataModel  extends LazyDataModel<DreamDaysCityDto> {

    private DreamDaysCityService datasource;

    public LazyDreamDaysCityDataModel(DreamDaysCityService dreamDaysCityService) {
        this.datasource = dreamDaysCityService;
    }

    @Override
    public int count(Map<String, FilterMeta> map) {
        return datasource.countDreamDaysCity();
    }

    @Override
    public DreamDaysCityDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findDreamDaysCityById(Long.valueOf(rowKey));
        else
            return new DreamDaysCityDto();
    }

    @Override
    public String getRowKey(DreamDaysCityDto dreamDaysCityDto) {
        return String.valueOf(dreamDaysCityDto.getId());
    }

    @Override
    public List<DreamDaysCityDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
