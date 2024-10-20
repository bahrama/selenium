package com.tahagasht.hotel.jsf.dreamdays;

import com.tahagasht.hotel.ejb.dto.CullucCityDto;
import com.tahagasht.hotel.ejb.dto.DreamDaysCityDto;
import com.tahagasht.hotel.ejb.model.CityMapping;
import com.tahagasht.hotel.ejb.service.CityMappingService;
import com.tahagasht.hotel.ejb.service.CullucCityService;
import com.tahagasht.hotel.ejb.service.DreamDaysCityService;
import com.tahagasht.hotel.jsf.culluc.LazyCullucCityDataModel;
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
public class DreamDaysCityViewManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private DreamDaysCityService dreamDaysCityService;

    @Inject
    private CityMappingService cityMappingService;

    @Getter
    @Setter
    private DreamDaysCityDto dreamDaysCityDto;

    @Getter
    @Setter
    private LazyDataModel<DreamDaysCityDto> lazyModel;

    @PostConstruct
    public void init(){
        lazyModel = new LazyDreamDaysCityDataModel(dreamDaysCityService);
        dreamDaysCityDto = new DreamDaysCityDto();
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
        dreamDaysCityDto = dreamDaysCityService.findDreamDaysCityById(id);
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/hotel-mapping/hotel-mapping.xhtml?providerName=Channelead&supplier=65&countryCode=IR&supplierHotelCode="+hotelChanneleadDto.getId()+"&cityCode="+hotelChanneleadDto.getCityCode());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city-mapping/city-mapping.xhtml?supplier=62&cityCode="+dreamDaysCityDto.getCityCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
