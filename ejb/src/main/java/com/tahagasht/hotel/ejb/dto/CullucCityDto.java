package com.tahagasht.hotel.ejb.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CullucCityDto {
    private Long id;
    private String cityName;
    private String cityCode;
    private String countryName;
    private String countryCode;
}
