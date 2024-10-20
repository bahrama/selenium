package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.City;
import com.tahagasht.hotel.ejb.model.Country;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
@LocalBean
public class CountryDao {
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    public List<Country> findAllCountry(){
        return em.createNamedQuery("Country.findAll").getResultList();
    }
}
