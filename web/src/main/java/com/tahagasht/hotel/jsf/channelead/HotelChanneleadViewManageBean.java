package com.tahagasht.hotel.jsf.channelead;

import com.tahagasht.hotel.ejb.dto.HotelChanneleadDto;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import com.tahagasht.hotel.ejb.service.HotelChanneleadService;
import com.tahagasht.hotel.ejb.service.HotelMappingService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class HotelChanneleadViewManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private LazyDataModel<HotelChanneleadDto> lazyModel;

    @Getter
    @Setter
    private HotelChanneleadDto hotelChanneleadDto;

    @Getter
    @Setter
    private Long channelId;

    public LazyDataModel<HotelChanneleadDto> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<HotelChanneleadDto> lazyModel) {
        this.lazyModel = lazyModel;
    }

    @Inject
    private HotelChanneleadService hotelChanneleadService;
    @Inject
    private HotelMappingService hotelMappingService;
    @PostConstruct
    public void init(){
        lazyModel = new LazyHotelChanneleadDataModel(hotelChanneleadService);
        hotelChanneleadDto = new HotelChanneleadDto();
    }
    public HotelMapping findHotelMappingByHotelCodeAndSupplierId(String hotelCode, Long supplierId) {
        try{
        return hotelMappingService.findHotelMappingByHotelCodeAndSupplierId(hotelCode, supplierId);
    }catch (Exception e){
            return null;
        }
    }


    public void goToMapping(Long id){
        hotelChanneleadDto = hotelChanneleadService.findHotelChanneleadById(id);
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/hotel-mapping/hotel-mapping.xhtml?providerName=Channelead&supplier=65&countryCode=IR&supplierHotelCode="+hotelChanneleadDto.getId()+"&cityCode="+hotelChanneleadDto.getCityCode());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/hotel-mapping/hotel-mapping.xhtml?providerName=Channelead&supplier=65&countryCode=IR&supplierHotelCode="+hotelChanneleadDto.getId()+"&cityCode="+hotelChanneleadDto.getCityCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
