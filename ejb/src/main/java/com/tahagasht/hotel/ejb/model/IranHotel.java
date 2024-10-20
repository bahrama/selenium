package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_iran_hotel", schema = "public", catalog = "postgres")
@Getter
@Setter
public class IranHotel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "Picture_Url", nullable = true, length = -1)
    private String pictureUrl;
    @Basic
    @Column(name = "Name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "City_Name", nullable = true, length = -1)
    private String cityName;
    @Basic
    @Column(name = "Type_Name", nullable = true, length = -1)
    private String typeName;
    @Basic
    @Column(name = "Grade_Name", nullable = true, length = -1)
    private String gradeName;
    @Basic
    @Column(name = "Chain_Name", nullable = true, length = -1)
    private String chainName;
    @Basic
    @Column(name = "State_Name", nullable = true, length = -1)
    private String stateName;
    @Basic
    @Column(name = "Address", nullable = true, length = -1)
    private String address;
    @Basic
    @Column(name = "Hotel_Rank", nullable = true, length = -1)
    private String hotelRank;
    @Basic
    @Column(name = "Rank_Name", nullable = true, length = -1)
    private String rankName;
    @Basic
    @Column(name = "City_Id", nullable = true, length = -1)
    private String cityId;
    @Basic
    @Column(name = "State_Id", nullable = true, length = -1)
    private String stateId;
    @Basic
    @Column(name = "Has_Free_Transfer", nullable = true, length = -1)
    private String hasFreeTransfer;

}
