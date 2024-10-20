package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Stateless
@LocalBean
public class HotelMappingDao {
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    public void save(HotelMapping hotelMapping) throws Exception {
        em.persist(hotelMapping);
    }

    public int countHotel(){
        String q = "select count(*) as count from t_hotel_mapping \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    public Optional<HotelMapping> findHotelById(Long id) {
        HotelMapping hotelMapping = em.find(HotelMapping.class , id);
        return hotelMapping != null ? Optional.of(hotelMapping):Optional.empty();
    }

    public Optional<HotelMapping> findHotelMappingByHotelCodeAndSupplierId(String hotelCode,Long supplierId) throws Exception {
        String q = "select * from t_hotel_mapping t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        queryBuilder.append(" where t.C_HOTEL_CODE=\'" + hotelCode + "\' and t.F_SUPPLIER="+supplierId);
        Query query = em.createNativeQuery(queryBuilder.toString(), HotelMapping.class);
        HotelMapping hotelMapping = (HotelMapping) query.getSingleResult();
        return hotelMapping != null ? Optional.of(hotelMapping):Optional.empty();
    }

}
