package com.tahagasht.hotel.jsf.mapping.hotel;

import com.tahagasht.hotel.ejb.dto.CityDto;
import com.tahagasht.hotel.ejb.dto.CountryDto;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.HotelMappingDto;
import com.tahagasht.hotel.ejb.service.HotelMappingService;
import com.tahagasht.hotel.ejb.service.HotelService;
import com.tahagasht.hotel.jsf.hotel.LazyHotelDataModel;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class HotelMappingViewManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private HotelMappingDto hotelMappingDto;
    @Getter
    @Setter
    private Long hotelId;



    @Inject
    private HotelMappingService hotelMappingService;

    @PostConstruct
    public void init(){
       hotelMappingDto = new HotelMappingDto();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void findHotelId(Long hotelId){
        this.hotelId=hotelId;
    }

    public void save(String providerName,Integer supplier ,String supplierHotelCode,String cityCode,String countryCode){
        try {
            hotelMappingDto.setHotelCode(supplierHotelCode);
            hotelMappingDto.setCityCode(cityCode);
            hotelMappingDto.setSupplier(supplier);
            hotelMappingDto.setProviderName(providerName);
            hotelMappingDto.setProviderType("gds");
            hotelMappingDto.setHotelId(hotelId);
            hotelMappingDto.setCountryCode(countryCode);
            hotelMappingService.save(hotelMappingDto);
            hotelMappingDto=new HotelMappingDto();
            addMessage(FacesMessage.SEVERITY_INFO, "Saved successfully",null);
            hotelId = null;
            hotelMappingDto = new HotelMappingDto();
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", null);
            e.printStackTrace();
        }
    }


}
