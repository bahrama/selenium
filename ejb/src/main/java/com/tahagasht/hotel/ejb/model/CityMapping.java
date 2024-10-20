package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_city_mapping", schema = "public", catalog = "postgres")
@Getter
@Setter
@Cacheable(value = false)
public class CityMapping {
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name = "t_city_mapping_id_seq", initialValue = 292000)
    @GeneratedValue(generator = "t_city_mapping_id_seq")
    private Long id;
    @Basic
    @Column(name = "C_SUPPLIER_CITY", nullable = true, length = -1)
    private String supplierCity;
    @Basic
    @Column(name = "F_CITY", nullable = true, precision = 0)
    private Long city;
    @Basic
    @Column(name = "F_SUPPLIER", nullable = true, precision = 0)
    private Integer supplier;


}
