package com.tahagasht.hotel.jsf.dreamdays;

import com.tahagasht.hotel.ejb.dto.DreamDaysHotelDto;
import com.tahagasht.hotel.ejb.dto.HotelChanneleadDto;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import com.tahagasht.hotel.ejb.service.DreamDaysHotelService;
import com.tahagasht.hotel.ejb.service.HotelChanneleadService;
import com.tahagasht.hotel.ejb.service.HotelMappingService;
import com.tahagasht.hotel.jsf.channelead.LazyHotelChanneleadDataModel;
import jakarta.annotation.PostConstruct;
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
public class DreamDaysHotelViewManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private LazyDataModel<DreamDaysHotelDto> lazyModel;

    @Getter
    @Setter
    private DreamDaysHotelDto dreamDaysHotelDto;

    @Getter
    @Setter
    private Long hotelId;

    @Inject
    private DreamDaysHotelService dreamDaysHotelService;
    @Inject
    private HotelMappingService hotelMappingService;

    @PostConstruct
    public void init(){
        lazyModel = new LazyDreamDaysHotelDataModel(dreamDaysHotelService);
        dreamDaysHotelDto = new DreamDaysHotelDto();
    }

    public HotelMapping findHotelMappingByHotelCodeAndSupplierId(String hotelCode, Long supplierId) {
        try{
            return hotelMappingService.findHotelMappingByHotelCodeAndSupplierId(hotelCode, supplierId);
        }catch (Exception e){
            return null;
        }
    }

    public void goToMapping(Long id){
        dreamDaysHotelDto = dreamDaysHotelService.findDreamDaysHotelById(id);
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/hotel-mapping/hotel-mapping.xhtml?providerName=Channelead&supplier=65&countryCode=IR&supplierHotelCode="+hotelChanneleadDto.getId()+"&cityCode="+hotelChanneleadDto.getCityCode());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/hotel-mapping/hotel-mapping.xhtml?providerName=DreamDaysNew&supplier=62&countryCode=AE&supplierHotelCode="+dreamDaysHotelDto.getHotelId()+"&cityCode="+dreamDaysHotelDto.getCityId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
