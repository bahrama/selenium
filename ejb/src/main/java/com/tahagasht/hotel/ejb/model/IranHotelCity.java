package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_iran_hotel_city", schema = "public", catalog = "postgres")
@Getter
@Setter
public class IranHotelCity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "title", nullable = true, length = -1)
    private String title;
}
