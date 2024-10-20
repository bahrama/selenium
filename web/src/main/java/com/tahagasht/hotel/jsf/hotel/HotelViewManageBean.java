package com.tahagasht.hotel.jsf.hotel;

import com.tahagasht.hotel.ejb.dto.CityDto;
import com.tahagasht.hotel.ejb.dto.CountryDto;
import com.tahagasht.hotel.ejb.dto.HotelDto;
import com.tahagasht.hotel.ejb.service.CityService;
import com.tahagasht.hotel.ejb.service.CountryService;
import com.tahagasht.hotel.ejb.service.HotelService;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Named
@ViewScoped
public class HotelViewManageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private HotelService hotelService;
    @Inject
    private CityService cityService;
    @Inject
    private CountryService countryService;

    private LazyDataModel<HotelDto> lazyModel;
    @Getter
    @Setter
    private CityDto cityDto;

    @Getter
    @Setter
    private HotelDto hotelDto;

    @Getter
    @Setter
    private CountryDto countryDto;

    @Getter
    @Setter
    private List<CityDto> cityDtos;
    @Getter
    @Setter
    private List<CityDto> selectCityDtos;
    @Getter
    @Setter
    private List<CountryDto> selectCountryDtos;
    @Getter
    @Setter
    private List<CountryDto> countryDtos;

    @PostConstruct
    public void init(){
        lazyModel = new LazyHotelDataModel(hotelService);
        hotelDto = new HotelDto();
        countryDto = new CountryDto();
        cityDto = new CityDto();
        cityDtos=findAllCity("IR");
        countryDtos=findAllCountry();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public LazyDataModel<HotelDto> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<HotelDto> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public void save(){
        try {
            hotelDto.setCity(selectCityDtos.get(0).getId());
            hotelDto.setCityName(selectCityDtos.get(0).getCityName());
            hotelDto.setPersianCityName(selectCityDtos.get(0).getCityPersianName());
            hotelDto.setCountryCode(selectCountryDtos.get(0).getCountryCode());
            hotelDto.setCountry(selectCountryDtos.get(0).getId());
            hotelDto.setLastUpdate(new Date());
            hotelService.save(hotelDto);
            hotelDto=new HotelDto();
            selectCityDtos.clear();
            selectCountryDtos.clear();
            addMessage(FacesMessage.SEVERITY_INFO, "Saved successfully",null);
        } catch (Exception e) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", null);
            e.printStackTrace();
        }
    }

    public List<CityDto> findAllCity(String countryCode){

        return cityService.findAllCity(countryCode);
    }

    public List<CountryDto> findAllCountry(){
        return countryService.findAllCountry();
    }


    public void onCityChange() {
      System.out.println(cityDto.getCityName());
    }
    public void onCountryChange() {
        System.out.println(countryDto.getCountryName());
    }

}
