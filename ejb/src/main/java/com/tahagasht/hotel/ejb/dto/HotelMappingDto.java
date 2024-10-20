package com.tahagasht.hotel.ejb.dto;

import com.tahagasht.hotel.ejb.model.Hotel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelMappingDto {
    private Long id;
    private String cityCode;
    private String countryCode;
    private Integer giataCode;
    private String hotelCode;
    private String providerName;
    private String providerType;
    private Integer supplier;
    private Long hotelId;
}
