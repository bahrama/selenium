package com.tahagasht.hotel.ejb.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelBookingDto {
    private Long id;
    private String hotelName;
    private String ficility;
    private String description;
    private String cityName;
    private String countryCode;
}
