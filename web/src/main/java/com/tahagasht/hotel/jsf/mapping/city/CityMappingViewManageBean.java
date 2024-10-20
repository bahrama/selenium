package com.tahagasht.hotel.jsf.mapping.city;

import com.tahagasht.hotel.ejb.dto.CityMappingDto;
import com.tahagasht.hotel.ejb.dto.HotelMappingDto;
import com.tahagasht.hotel.ejb.service.CityMappingService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named
@ViewScoped
public class CityMappingViewManageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private CityMappingDto cityMappingDto;
    @Getter
    @Setter
    private Long cityId;

    @Inject
    private CityMappingService cityMappingService;

    @PostConstruct
    public void init(){
        cityMappingDto = new CityMappingDto();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void findCityId(Long cityId){
        this.cityId=cityId;
    }

    public void save(Integer supplierId,String cityCode){
        try {
            cityMappingDto.setCity(cityId);
            cityMappingDto.setSupplier(supplierId);
            cityMappingDto.setSupplierCity(cityCode);
            cityMappingService.save(cityMappingDto);
            addMessage(FacesMessage.SEVERITY_INFO, "Saved successfully",null);
            cityId = null;
            cityMappingDto = new CityMappingDto();
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", null);
            e.printStackTrace();
        }
    }


}
