package com.tahagasht.hotel.jsf.iranhotel;

import com.tahagasht.hotel.ejb.dto.IranHotelDto;
import com.tahagasht.hotel.ejb.dto.SnappTripDto;
import com.tahagasht.hotel.ejb.service.IranHotelService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyIranHotelDataModel extends LazyDataModel<IranHotelDto> {
    private IranHotelService datasource;

    public LazyIranHotelDataModel(IranHotelService iranHotelService) {
        this.datasource = iranHotelService;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        return datasource.countIranHotel(filter);
    }

    @Override
    public IranHotelDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return datasource.findIranHotelById(Long.valueOf(rowKey));
        else
            return new IranHotelDto();
    }

    @Override
    public String getRowKey(IranHotelDto iranHotelDto) {
        return String.valueOf(iranHotelDto.getId());
    }

    @Override
    public List<IranHotelDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
