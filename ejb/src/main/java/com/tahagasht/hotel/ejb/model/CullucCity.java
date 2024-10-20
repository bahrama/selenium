package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "culluc_city", schema = "public", catalog = "postgres")
@Getter
@Setter
@Cacheable(value = false)
public class CullucCity {
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Basic
    @Column(name = "city_name", nullable = true, length = 200)
    private String cityName;
    @Column(name = "city_code", nullable = true, length = 200)
    private String cityCode;
    @Basic
    @Column(name = "country_name", nullable = true, length = 200)
    private String countryName;
    @Basic
    @Column(name = "country_code", nullable = true, length = 200)
    private String countryCode;

}
