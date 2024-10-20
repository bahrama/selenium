package com.tahagasht.hotel.ejb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingMatchWithHotelDto {
    private Double bookingLat;
    private Double bookingLng;
    private String bookingHotelName;
    private Long hotelId;
    private String hotelName;
    private Double hotelLat;
    private Double hotelLng;
}
