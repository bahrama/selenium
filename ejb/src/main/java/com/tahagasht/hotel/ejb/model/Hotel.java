package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_HOTEL", schema = "public", catalog = "postgres")
@Getter
@Setter
@Cacheable(value = false)
public class Hotel {
    @SequenceGenerator(name = "t_hotel_id_seq", initialValue = 1429271)
    @GeneratedValue(generator = "t_hotel_id_seq")
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private Long id;
    @Basic
    @Column(name = "C_ADDRESSES", nullable = true, length = -1)
    private String addresses;
    @Basic
    @Column(name = "C_AIRPORTS", nullable = true, length = -1)
    private String airports;
    @Basic
    @Column(name = "C_AUTOFILL_TEXT", nullable = true, length = -1)
    private String autofillText;
    @Basic
    @Column(name = "C_CITY_NAME", nullable = true, length = -1)
    private String cityName;
    @Basic
    @Column(name = "C_COMMENT", nullable = true, length = -1)
    private String comment;
    @Basic
    @Column(name = "C_COUNTRY_CODE", nullable = true, length = -1)
    private String countryCode;
    @Basic
    @Column(name = "N_DESTINATION_ID", nullable = true, precision = 0)
    private Integer destinationId;
    @Basic
    @Column(name = "C_DESTINATION_NAME", nullable = true, length = -1)
    private String destinationName;
    @Basic
    @Column(name = "C_GEO_ACCURACY", nullable = true, length = -1)
    private String geoAccuracy;
    @Basic
    @Column(name = "N_GIATA_CODE", nullable = true, precision = 0)
    private Integer giataCode;
    @Basic
    @Column(name = "D_LAST_UPDATE", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic
    @Column(name = "N_LATITUDE", nullable = true, precision = 10)
    private Double latitude;
    @Basic
    @Column(name = "N_LONGITUDE", nullable = true, precision = 10)
    private Double longitude;
    @Basic
    @Column(name = "C_NAME", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "C_PERSIAN_ADDRESSES", nullable = true, length = -1)
    private String persianAddresses;
    @Basic
    @Column(name = "C_PERSIAN_CITY_NAME", nullable = true, length = -1)
    private String persianCityName;
    @Basic
    @Column(name = "C_PERSIAN_NAME", nullable = true, length = -1)
    private String persianName;
    @Basic
    @Column(name = "C_PHONES", nullable = true, length = -1)
    private String phones;
    @Basic
    @Column(name = "C_PICTURE_URL", nullable = true, length = -1)
    private String pictureUrl;
    @Basic
    @Column(name = "C_POSTAL_CODE", nullable = true, length = -1)
    private String postalCode;
    @Basic
    @Column(name = "N_RATING", nullable = true, precision = 10)
    private Double rating;
    @Basic
    @Column(name = "C_URLS", nullable = true, length = -1)
    private String urls;
    @Basic
    @Column(name = "C_VENDOR", nullable = true, length = -1)
    private String vendor;
    @Basic
    @Column(name = "F_AGENCY", nullable = true, precision = 0)
    private Integer agency;
    @Basic
    @Column(name = "F_CITY", nullable = true, precision = 0)
    private Long city;
    @Basic
    @Column(name = "F_COUNTRY", nullable = true, precision = 0)
    private Long country;
    @Basic
    @Column(name = "F_CURRENCY", nullable = true, precision = 0)
    private Integer currency;
    @Basic
    @Column(name = "F_HOTELCHAIN", nullable = true, precision = 0)
    private Integer hotelchain;
    @Basic
    @Column(name = "F_PICTURE", nullable = true, precision = 0)
    private Integer picture;

}
