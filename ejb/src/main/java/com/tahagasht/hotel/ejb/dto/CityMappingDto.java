package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.City;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityMappingDto {
    private Long id;
    private Long city;
    private String supplierCity;
    private Integer supplier;
}
