package com.tahagasht.hotel.ejb.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CityDto {
    private Long id;
    private String autofillText;
    private String cityIataCode;
    private String cityName;
    private String cityPersianName;
    private String countryCode;
    private String countryName;
    private Integer giataCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return Objects.equals(id, cityDto.id) && Objects.equals(autofillText, cityDto.autofillText) && Objects.equals(cityIataCode, cityDto.cityIataCode) && Objects.equals(cityName, cityDto.cityName) && Objects.equals(cityPersianName, cityDto.cityPersianName) && Objects.equals(countryCode, cityDto.countryCode) && Objects.equals(countryName, cityDto.countryName) && Objects.equals(giataCode, cityDto.giataCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autofillText, cityIataCode, cityName, cityPersianName, countryCode, countryName, giataCode);
    }
}
