package com.tahagasht.hotel.jsf.iranhotel;

import com.tahagasht.hotel.ejb.dao.IranHotelDao;
import com.tahagasht.hotel.ejb.dto.IranHotelDto;
import com.tahagasht.hotel.ejb.dto.SnappTripCityDto;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import com.tahagasht.hotel.ejb.service.HotelMappingService;
import com.tahagasht.hotel.ejb.service.IranHotelService;
import com.tahagasht.hotel.jsf.snapptrip.LazySnappTripCityDataModel;
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
public class IranHotelViewManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private LazyDataModel<IranHotelDto> lazyModel;
    @Inject
    private IranHotelService iranHotelService;
    @Getter
    @Setter
    private IranHotelDto iranHotelDto;
    @Inject
    private HotelMappingService hotelMappingService;

    @PostConstruct
    public void init(){
        lazyModel = new LazyIranHotelDataModel(iranHotelService);
        iranHotelDto = new IranHotelDto();
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
        iranHotelDto = iranHotelService.findIranHotelById(id);
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/hotel-mapping/hotel-mapping.xhtml?providerName=Channelead&supplier=65&countryCode=IR&supplierHotelCode="+hotelChanneleadDto.getId()+"&cityCode="+hotelChanneleadDto.getCityCode());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/hotel-mapping/hotel-mapping.xhtml?providerName=IranHotel&supplier=67&countryCode=IR&supplierHotelCode="+iranHotelDto.getId()+"&cityCode="+iranHotelDto.getCityId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
