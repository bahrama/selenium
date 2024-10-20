package com.tahagasht.hotel.jsf.culluc;

import com.tahagasht.hotel.ejb.dto.CityDto;
import com.tahagasht.hotel.ejb.dto.CullucCityDto;
import com.tahagasht.hotel.ejb.service.CullucCityService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyCullucCityDataModel extends LazyDataModel<CullucCityDto> {

    private CullucCityService datasource;

    public LazyCullucCityDataModel(CullucCityService cullucCityService) {
        this.datasource = cullucCityService;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        return datasource.countCullucCity(filter);
    }

    @Override
    public CullucCityDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findCullucCityById(Long.valueOf(rowKey));
        else
            return new CullucCityDto();
    }

    @Override
    public String getRowKey(CullucCityDto cityDto) {
        return String.valueOf(cityDto.getId());
    }

    @Override
    public List<CullucCityDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
