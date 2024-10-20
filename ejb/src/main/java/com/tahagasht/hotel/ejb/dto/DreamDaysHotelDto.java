package com.tahagasht.hotel.ejb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DreamDaysHotelDto {
    private Long id;
    private String hotelId;
    private String hotelName;
    private String latitude;
    private String longitude;
    private String address;
    private String rating;
    private String countryId;
    private String countryName;
    private String cityId;
    private String cityName;
    private String giataId;
    private String hotelFrontImage;
    private String isRecomondedHotel;
    private String isActive;
    private String updatedDate;
}
