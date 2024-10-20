package com.tahagasht.hotel.jsf.template;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionListener;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class TemplateViewManageBean implements Serializable {
    public void goToHotelPage(){
        try {
           // FacesContext.getCurrentInstance().getExternalContext().redirect("/hotel/hotel.xhtml");
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/hotel/hotel.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToAddHotelPage(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/hotel/hotel-form.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/hotel/hotel-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToChanneleadHotel(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/channelead/channelead.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/channelead/channelead.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToBookingCom(){
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/bookingcom/bookingSearch.xhtml");
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/bookingcom/bookingSearch.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToCity(){
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/city/city.xhtml");
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToCityForm(){
        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/city/city-form.xhtml");
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToCullucCity(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/culluc/culluc.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToDreamDaysCity(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/dreamdays/dreamdays.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToDreamDaysHotel(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/dreamdays/dreamdays-hotel.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToSnappTripHotel(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/snapptrip/snapptrip.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getGoToSnappTripCity() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/snapptrip/snapptrip-city.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getGoToIranHotel() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/iranhotel/iranhotel.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getGoToIranHotelCity() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/iranhotel/iranhotel-city.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("/HotelUtitlity-web/city/city-form.xhtml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
