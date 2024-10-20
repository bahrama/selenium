package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_hotel_mapping", schema = "public", catalog = "postgres")
@Getter
@Setter
@Cacheable(value = false)
public class HotelMapping {
    @SequenceGenerator(name = "t_hotel_mapping_id_seq", initialValue = 10947881)
    @GeneratedValue(generator = "t_hotel_mapping_id_seq")
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private Long id;
    @Basic
    @Column(name = "C_CITY_CODE", nullable = true, length = -1)
    private String cityCode;
    @Basic
    @Column(name = "C_COUNTRY_CODE", nullable = true, length = -1)
    private String countryCode;
    @Basic
    @Column(name = "N_GIATA_CODE", nullable = true, precision = 0)
    private Integer giataCode;
    @Basic
    @Column(name = "C_HOTEL_CODE", nullable = true, length = -1)
    private String hotelCode;
    @Basic
    @Column(name = "C_PROVIDER_NAME", nullable = true, length = -1)
    private String providerName;
    @Basic
    @Column(name = "C_PROVIDER_TYPE", nullable = true, length = -1)
    private String providerType;
    @Basic
    @Column(name = "F_HOTEL", nullable = true, precision = 0)
    private Long hotelId;
    @Basic
    @Column(name = "F_SUPPLIER", nullable = true, precision = 0)
    private Integer supplier;
}
