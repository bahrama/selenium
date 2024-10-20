package com.tahagasht.hotel.ejb.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class HotelChanneleadDto implements Serializable {
    private String id;
    private String cityId;
    private String name;
    private String nameEn;
    private String neighbourhood;
    private String cityCode;
    private String cityName;
    private String address1;
    private String address2;
    private String location;
    private String imageUrl;

    public HotelChanneleadDto(){

    }

    public HotelChanneleadDto(String id, String cityId, String name, String nameEn, String neighbourhood, String cityCode, String cityName, String address1, String address2, String location, String imageUrl) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.nameEn = nameEn;
        this.neighbourhood = neighbourhood;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.address1 = address1;
        this.address2 = address2;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelChanneleadDto that = (HotelChanneleadDto) o;
        return Objects.equals(id, that.id) && Objects.equals(cityId, that.cityId) && Objects.equals(name, that.name) && Objects.equals(nameEn, that.nameEn) && Objects.equals(neighbourhood, that.neighbourhood) && Objects.equals(cityCode, that.cityCode) && Objects.equals(cityName, that.cityName) && Objects.equals(address1, that.address1) && Objects.equals(address2, that.address2) && Objects.equals(location, that.location) && Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityId, name, nameEn, neighbourhood, cityCode, cityName, address1, address2, location, imageUrl);
    }
}
