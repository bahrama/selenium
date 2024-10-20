package com.tahagasht.hotel.ejb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_country", schema = "public", catalog = "postgres")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name="Country.findAll", query="SELECT m FROM Country m ORDER BY m.id ASC")
})
@Cacheable(value = false)
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private Long id;
    @Basic
    @Column(name = "C_AUTOFILL_TEXT", nullable = true, length = -1)
    private String autofillText;
    @Basic
    @Column(name = "C_COUNTRY_CODE", nullable = true, length = -1)
    private String countryCode;
    @Basic
    @Column(name = "C_COUNTRY_NAME", nullable = true, length = -1)
    private String countryName;
    @Basic
    @Column(name = "C_COUNTRY_PREFIX", nullable = true, length = -1)
    private String countryPrefix;
    @Basic
    @Column(name = "C_CURRENCY_CODE", nullable = true, length = -1)
    private String currencyCode;

}
