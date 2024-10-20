package com.tahagasht.hotel.jsf.snapptrip;

import com.tahagasht.hotel.ejb.dto.SnappTripCityDto;
import com.tahagasht.hotel.ejb.dto.SnappTripDto;
import com.tahagasht.hotel.ejb.model.CityMapping;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import com.tahagasht.hotel.ejb.service.CityMappingService;
import com.tahagasht.hotel.ejb.service.SnappTripCityService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.LazyDataModel;

import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class SnappTripCityViewManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private LazyDataModel<SnappTripCityDto> lazyModel;
    @Getter
    @Setter
    private SnappTripCityDto snappTripCityDto;
    @Inject
    private SnappTripCityService snappTripCityService;
    @Inject
    private CityMappingService cityMappingService;

    @PostConstruct
    public void init(){
        lazyModel = new LazySnappTripCityDataModel(snappTripCityService);
        snappTripCityDto = new SnappTripCityDto();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public CityMapping findHotelMappingByHotelCodeAndSupplierId(String cityCode, Long supplierId) {
        try{
            return cityMappingService.findCityMappingByHotelCodeAndSupplierId(cityCode, supplierId);
        }catch (Exception e){
            return null;
        }
    }

    public void goToCityMapping(Long id){
        snappTripCityDto = snappTripCityService.findSnappTripCityById(id);
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/hotel-mapping/hotel-mapping.xhtml?providerName=Channelead&supplier=65&countryCode=IR&supplierHotelCode="+hotelChanneleadDto.getId()+"&cityCode="+hotelChanneleadDto.getCityCode());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city-mapping/city-mapping.xhtml?supplier=66&cityCode="+snappTripCityDto.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
