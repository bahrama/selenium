package com.tahagasht.hotel.jsf.bookingee;

import com.tahagasht.hotel.ejb.dto.SearchHotelModel;
import com.tahagasht.hotel.ejb.model.HotelBooking;
import com.tahagasht.hotel.ejb.service.BookingComService;
import com.tahagasht.hotel.ejb.service.HotelService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import lombok.Getter;
import lombok.Setter;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ViewScoped
@Named
public class BookingSearchManageBean implements Serializable {
    @Getter
    @Setter
    private String countryCode;

    @Getter
    @Setter
    private String cityName;

    private static String countryCode2;
    private static String cityName2;
    @Inject
    private BookingComService bookingComService;

    @Getter
    @Setter
    private List<SearchHotelModel> selectedHotel;
    @Getter
    @Setter
    private Set<SearchHotelModel> searchlist = new HashSet<>();
    @Inject
    private HotelService hotelService;

    public boolean checkFindHotel(String hotelName,Double lat,Double lng){
        List<Tuple> hotels = hotelService.findHotelByNameOrLatAndLng(hotelName,lat,lng);
        if(hotels.isEmpty()) return false;
        else return true;
    }
    public void searchHotel(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/bookingcom/BookingSearchResult.xhtml?cityName=" + cityName + "&countryCode=" + countryCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void findHotelDetail(){
        selectedHotel.forEach(s->{
            System.out.println(s.getName());
            try {
                bookingComService.findHotelDetail(s.getName(),s.getUrl(),cityName2,countryCode2);
            } catch (Exception e) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Successful"));
            }
        });
    }


    public Set<SearchHotelModel> searchHotelModelList(String cityName, String countryCode){
        cityName2 = cityName;
        countryCode2 = countryCode;
        try {
            if (searchlist.isEmpty()) {
                bookingComService.getSearchHotelModels().clear();
                bookingComService.findHotelsByCity(cityName, countryCode);
                searchlist.addAll(bookingComService.getSearchHotelModels());
                return searchlist;
            }
            else return searchlist;
        }catch (Exception e){
            searchlist.addAll(bookingComService.getSearchHotelModels());
            return searchlist;
        }
    }

    public Boolean findHotelBookingByName(String hotelName){
        try {
                   if(bookingComService.findHotelBookingByName(hotelName)!=null){
                       return true;
                   }
                   else return false;

        } catch (Exception e) {
            return false;
        }
    }

}
