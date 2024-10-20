package com.tahagasht.hotel.ejb.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class HotelDto {
    private Long id;
    private String addresses;
    private String airports;
    private String autofillText;
    private String cityName;
    private String comment;
    private String countryCode;
    private Integer destinationId;
    private String destinationName;
    private String geoAccuracy;
    private Integer giataCode;
    private Date lastUpdate;
    private Double latitude;
    private Double longitude;
    private String name;
    private String persianAddresses;
    private String persianCityName;
    private String persianName;
    private String phones;
    private String pictureUrl;
    private String postalCode;
    private Double rating;
    private String urls;
    private String vendor;
    private Integer agency;
    private Long city;
    private Long country;
    private Integer currency;
    private Integer hotelchain;
    private Integer picture;
}
