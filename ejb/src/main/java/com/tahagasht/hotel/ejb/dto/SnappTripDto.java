package com.tahagasht.hotel.ejb.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SnappTripDto {
    private Long hotelCode;
    private String nothing;
    private String hotelName;
    private String hotelType;
    private String cityCode;
    private String cityName;
}
