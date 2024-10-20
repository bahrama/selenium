package com.tahagasht.hotel.ejb.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SnappTripCityDto {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String stateId;
    private String stateTitle;
}
