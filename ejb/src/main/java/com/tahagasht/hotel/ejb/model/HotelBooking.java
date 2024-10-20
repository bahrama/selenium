package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity(name="T_HOTEL_BOOKING_COM")
@Table(name="T_HOTEL_BOOKING_COM")
@Getter
@Setter
@Cacheable(value = false)
public class HotelBooking implements Serializable {
    public HotelBooking() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="C_HOTEL_NAME" , length = 500)
    private String hotelName;
    @Column(name="C_FACILITY" , length = 2000)
    private String ficility;
    @Column(name="C_DESCRIPTION" , length = 2000)
    private String description;
    @Column(name="T_CITY_NAME" , length = 2000)
    private String cityName;
    @Column(name="T_COUNTRY_CODE" , length = 2000)
    private String countryCode;
    private Double lat;
    private Double lng;
}
