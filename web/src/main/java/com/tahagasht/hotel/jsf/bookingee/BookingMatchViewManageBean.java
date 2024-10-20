package com.tahagasht.hotel.jsf.bookingee;

import com.tahagasht.hotel.ejb.dto.BookingMatchWithHotelDto;
import com.tahagasht.hotel.ejb.service.BookingComService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class BookingMatchViewManageBean  implements Serializable {
    @Inject
    private BookingComService bookingComService;

    public List<BookingMatchWithHotelDto> findBookingMatchWithHotelDtos(){
       return bookingComService.findBookingMatchWithHotelDtos();
    }
}
