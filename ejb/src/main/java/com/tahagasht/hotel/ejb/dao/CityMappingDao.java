package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.CityMapping;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Stateless
@LocalBean
public class CityMappingDao {
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    public Optional<CityMapping> findCityMappingByHotelCodeAndSupplierId(String cityCode, Long supplierId) throws Exception {
        String q = "select * from t_city_mapping t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        queryBuilder.append(" where t.C_SUPPLIER_CITY=\'" + cityCode + "\' and t.F_SUPPLIER="+supplierId);
        Query query = em.createNativeQuery(queryBuilder.toString(), CityMapping.class);
        CityMapping cityMapping = (CityMapping) query.getSingleResult();
        return cityMapping != null ? Optional.of(cityMapping):Optional.empty();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void save(CityMapping cityMapping) throws Exception {
        em.persist(cityMapping);
    }

    public Optional<CityMapping> findCityMappingById(Long id) {
        CityMapping cityMapping = em.find(CityMapping.class , id);
        return cityMapping != null ? Optional.of(cityMapping):Optional.empty();
    }


}
