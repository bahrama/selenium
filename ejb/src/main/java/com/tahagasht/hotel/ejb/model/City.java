package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_city", schema = "public", catalog = "postgres")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name="city.findByCountry", query="SELECT m FROM City m where m.countryCode=:v_countryCode ORDER BY m.id ASC")
})
@Cacheable(value = false)
public class City {
    @SequenceGenerator(name = "t_city_id_seq", initialValue = 131707)
    @GeneratedValue(generator = "t_city_id_seq")
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private Long id;
    @Basic
    @Column(name = "C_AUTOFILL_TEXT", nullable = true, length = -1)
    private String autofillText;
    @Basic
    @Column(name = "C_CITY_IATA_CODE", nullable = true, length = -1)
    private String cityIataCode;
    @Basic
    @Column(name = "C_CITY_NAME", nullable = true, length = -1)
    private String cityName;
    @Basic
    @Column(name = "C_CITY_PERSIAN_NAME", nullable = true, length = -1)
    private String cityPersianName;
    @Basic
    @Column(name = "C_COUNTRY_CODE", nullable = true, length = -1)
    private String countryCode;
    @Basic
    @Column(name = "C_COUNTRY_NAME", nullable = true, length = -1)
    private String countryName;
    @Basic
    @Column(name = "N_GIATA_CODE", nullable = true, precision = 0)
    private Integer giataCode;

}
