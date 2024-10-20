package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_snapp_trip", schema = "public", catalog = "postgres")
@Getter
@Setter
public class SnappTrip {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "hotel_code", nullable = false)
    private Long hotelCode;
    @Basic
    @Column(name = "nothing", nullable = true, length = -1)
    private String nothing;
    @Basic
    @Column(name = "hotel_name", nullable = true, length = -1)
    private String hotelName;
    @Basic
    @Column(name = "hotel_type", nullable = true, length = -1)
    private String hotelType;
    @Basic
    @Column(name = "city_code", nullable = true, length = -1)
    private String cityCode;
    @Basic
    @Column(name = "city_name", nullable = true, length = -1)
    private String cityName;

}
