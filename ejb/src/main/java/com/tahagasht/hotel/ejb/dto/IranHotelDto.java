package com.tahagasht.hotel.ejb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IranHotelDto {
    private Long id;
    private String pictureUrl;
    private String name;
    private String cityName;
    private String typeName;
    private String gradeName;
    private String chainName;
    private String stateName;
    private String address;
    private String hotelRank;
    private String rankName;
    private String cityId;
    private String stateId;
    private String hasFreeTransfer;
}
