package com.tahagasht.hotel.ejb.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CountryDto {
    private Long id;
    private String autofillText;
    private String countryCode;
    private String countryName;
    private String countryPrefix;
    private String currencyCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto that = (CountryDto) o;
        return Objects.equals(id, that.id) && Objects.equals(autofillText, that.autofillText) && Objects.equals(countryCode, that.countryCode) && Objects.equals(countryName, that.countryName) && Objects.equals(countryPrefix, that.countryPrefix) && Objects.equals(currencyCode, that.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autofillText, countryCode, countryName, countryPrefix, currencyCode);
    }

    public static interface IranHotelCityDtoManager {
    }
}
