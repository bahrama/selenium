package com.tahagasht.hotel.jsf.snapptrip;

import com.tahagasht.hotel.ejb.dto.CityDto;
import com.tahagasht.hotel.ejb.dto.CountryDto;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.dto.SnappTripDto;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import com.tahagasht.hotel.ejb.service.HotelMappingService;
import com.tahagasht.hotel.ejb.service.SnappTripService;
import com.tahagasht.hotel.jsf.hotel.LazyHotelDataModel;
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
public class SnappTripDataViewManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SnappTripService snappTripService;
    @Inject
    private HotelMappingService hotelMappingService;

    @Getter
    @Setter
    private LazyDataModel<SnappTripDto> lazyModel;

    @Getter
    @Setter
    private SnappTripDto snappTripDto;

    @PostConstruct
    public void init(){
        lazyModel = new LazySnappTripDataModel(snappTripService);
        snappTripDto = new SnappTripDto();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public HotelMapping findHotelMappingByHotelCodeAndSupplierId(String hotelCode, Long supplierId) {
        try{
            return hotelMappingService.findHotelMappingByHotelCodeAndSupplierId(hotelCode, supplierId);
        }catch (Exception e){
            return null;
        }
    }

    public void goToMapping(Long id){
        snappTripDto = snappTripService.findSnappTripById(id);
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/hotel-mapping/hotel-mapping.xhtml?providerName=Channelead&supplier=65&countryCode=IR&supplierHotelCode="+hotelChanneleadDto.getId()+"&cityCode="+hotelChanneleadDto.getCityCode());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/hotel-mapping/hotel-mapping.xhtml?providerName=SnappTrip&supplier=66&countryCode=IR&supplierHotelCode="+snappTripDto.getHotelCode()+"&cityCode="+snappTripDto.getCityCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
