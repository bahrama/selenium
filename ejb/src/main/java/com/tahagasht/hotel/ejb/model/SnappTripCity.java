package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_snapp_trip_city", schema = "public", catalog = "postgres")
@Getter
@Setter
public class SnappTripCity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "title", nullable = true, length = -1)
    private String title;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "state_id", nullable = true, length = -1)
    private String stateId;
    @Basic
    @Column(name = "state_title", nullable = true, length = -1)
    private String stateTitle;

}
