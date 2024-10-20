package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dreamdays_city", schema = "public", catalog = "postgres")
@Getter
@Setter
@Cacheable(value = false)
public class DreamdaysCity {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "city_code", nullable = true, length = -1)
    private String cityCode;
    @Basic
    @Column(name = "city_name", nullable = true, length = -1)
    private String cityName;

}
