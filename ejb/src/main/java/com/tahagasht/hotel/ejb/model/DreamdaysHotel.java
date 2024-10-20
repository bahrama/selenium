package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dreamdays_hotel", schema = "public", catalog = "postgres")
@Getter
@Setter
@Cacheable(value = false)
public class DreamdaysHotel {
    @Id
    private Long id;
    @Basic
    @Column(name = "HotelId", nullable = true, length = -1)
    private String hotelId;
    @Basic
    @Column(name = "HotelName", nullable = true, length = -1)
    private String hotelName;
    @Basic
    @Column(name = "Latitude", nullable = true, length = -1)
    private String latitude;
    @Basic
    @Column(name = "Longitude", nullable = true, length = -1)
    private String longitude;
    @Basic
    @Column(name = "Address", nullable = true, length = -1)
    private String address;
    @Basic
    @Column(name = "Rating", nullable = true, length = -1)
    private String rating;
    @Basic
    @Column(name = "CountryId", nullable = true, length = -1)
    private String countryId;
    @Basic
    @Column(name = "CountryName", nullable = true, length = -1)
    private String countryName;
    @Basic
    @Column(name = "CityId", nullable = true, length = -1)
    private String cityId;
    @Basic
    @Column(name = "CityName", nullable = true, length = -1)
    private String cityName;
    @Basic
    @Column(name = "GiataId", nullable = true, length = -1)
    private String giataId;
    @Basic
    @Column(name = "HotelFrontImage", nullable = true, length = -1)
    private String hotelFrontImage;
    @Basic
    @Column(name = "IsRecomondedHotel", nullable = true, length = -1)
    private String isRecomondedHotel;
    @Basic
    @Column(name = "IsActive", nullable = true, length = -1)
    private String isActive;
    @Basic
    @Column(name = "UpdatedDate", nullable = true, length = -1)
    private String updatedDate;

}
