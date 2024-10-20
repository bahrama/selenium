package com.tahagasht.hotel.ejb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class SearchHotelModel {
    private Long id;
    private String name;
    private String cityCode;
    private String countryCode;
    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchHotelModel that = (SearchHotelModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cityCode, that.cityCode) && Objects.equals(countryCode, that.countryCode) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityCode, countryCode, url);
    }
}
