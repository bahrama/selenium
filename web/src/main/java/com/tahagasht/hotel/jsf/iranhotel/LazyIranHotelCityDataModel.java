package com.tahagasht.hotel.jsf.iranhotel;

import com.tahagasht.hotel.ejb.dto.IranHotelCityDto;
import com.tahagasht.hotel.ejb.service.IranHotelCityService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyIranHotelCityDataModel extends LazyDataModel<IranHotelCityDto> {
    private IranHotelCityService datasource;

    public LazyIranHotelCityDataModel(IranHotelCityService datasource) {
        this.datasource = datasource;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        return datasource.countIranHotelCity(filter);
    }

    @Override
    public IranHotelCityDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findIranHotelCityById(Long.valueOf(rowKey));
        else
            return new IranHotelCityDto();
    }

    @Override
    public String getRowKey(IranHotelCityDto iranHotelCityDto) {
        return String.valueOf(iranHotelCityDto.getId());
    }

    @Override
    public List<IranHotelCityDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
