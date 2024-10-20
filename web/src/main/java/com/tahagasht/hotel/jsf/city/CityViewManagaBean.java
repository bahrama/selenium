package com.tahagasht.hotel.jsf.city;

import com.tahagasht.hotel.ejb.dto.CityDto;
import com.tahagasht.hotel.ejb.dto.CountryDto;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.service.CityService;
import com.tahagasht.hotel.ejb.service.CountryService;
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

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class CityViewManagaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CityService cityService;
    @Getter
    @Setter
    private CityDto cityDto;
    @Getter
    @Setter
    private LazyDataModel<CityDto> lazyModel;
    @Getter
    @Setter
    private List<CountryDto> selectCountryDtos;
    @Getter
    @Setter
    private List<CountryDto> countryDtos;
    @Inject
    private CountryService countryService;

    @PostConstruct
    public void init(){
        lazyModel = new LazyCityDataModel(cityService);
        cityDto = new CityDto();
        countryDtos=findAllCountry();
    }

    public List<CountryDto> findAllCountry(){
        return countryService.findAllCountry();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void save(){
        try {
            cityDto.setCountryCode(selectCountryDtos.get(0).getCountryCode());
            cityDto.setCountryName(selectCountryDtos.get(0).getCountryName());
            cityService.save(cityDto);
            cityDto=new CityDto();
            selectCountryDtos.clear();
            addMessage(FacesMessage.SEVERITY_INFO, "Saved successfully",null);
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", null);
            e.printStackTrace();
        }
    }




}
