package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "t_hotel_channelead", schema = "public", catalog = "postgres")
@Getter
@Setter
@Cacheable(value = false)
public class HotelChannelead implements Serializable {
    @Basic
    @Column(name = "id", nullable = true, length = -1)
    @Id
    private String id;
    @Basic
    @Column(name = "city_id", nullable = true, length = -1)
    private String cityId;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "name_en", nullable = true, length = -1)
    private String nameEn;
    @Basic
    @Column(name = "neighbourhood", nullable = true, length = -1)
    private String neighbourhood;
    @Basic
    @Column(name = "city_code", nullable = true, length = -1)
    private String cityCode;
    @Basic
    @Column(name = "city_name", nullable = true, length = -1)
    private String cityName;
    @Basic
    @Column(name = "address1", nullable = true, length = -1)
    private String address1;
    @Basic
    @Column(name = "address2", nullable = true, length = -1)
    private String address2;
    @Basic
    @Column(name = "location", nullable = true, length = -1)
    private String location;
    @Basic
    @Column(name = "image_url", nullable = true, length = -1)
    private String imageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelChannelead that = (HotelChannelead) o;
        return Objects.equals(id, that.id) && Objects.equals(cityId, that.cityId) && Objects.equals(name, that.name) && Objects.equals(nameEn, that.nameEn) && Objects.equals(neighbourhood, that.neighbourhood) && Objects.equals(cityCode, that.cityCode) && Objects.equals(cityName, that.cityName) && Objects.equals(address1, that.address1) && Objects.equals(address2, that.address2) && Objects.equals(location, that.location) && Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityId, name, nameEn, neighbourhood, cityCode, cityName, address1, address2, location, imageUrl);
    }
}
