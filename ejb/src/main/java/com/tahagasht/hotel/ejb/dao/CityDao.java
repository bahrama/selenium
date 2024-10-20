package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.City;
import com.tahagasht.hotel.ejb.model.Hotel;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Stateless
@LocalBean
public class CityDao {

    @PersistenceContext(unitName = "aliUnit")
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    public void save(City city) throws Exception {
        em.persist(city);
    }

    public int countCity() {
        String q = "select count(*) as count from t_city \n";
        StringBuilder queryBuilder = new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    public List<City> findAllCity(String countryCode) {
        return em.createNamedQuery("city.findByCountry").setParameter("v_countryCode", countryCode).getResultList();
    }


    public Optional<City> findCityById(Long id) {
        City city = em.find(City.class, id);
        return city != null ? Optional.of(city) : Optional.empty();
    }

    public List<City> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from t_city t\n";
        StringBuilder queryBuilder = new StringBuilder(q);
        if (filterBy.size() > 0) {
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k, v) -> {
                if (k.equals("id")) k = "ID";
                if (k.equals("autofillText")) k = "C_AUTOFILL_TEXT";
                if (k.equals("cityIataCode")) k = "C_CITY_IATA_CODE";
                if (k.equals("cityName")) k = "C_CITY_NAME";
                if (k.equals("cityPersianName")) k = "C_CITY_PERSIAN_NAME";
                if (k.equals("countryCode")) k = "C_COUNTRY_CODE";
                if (k.equals("countryName")) k = "C_COUNTRY_NAME";
                if (k.equals("giataCode")) k = "N_GIATA_CODE";
                if (k.equals("ID")) queryBuilder.append(" and t." + k + "=" + v + "\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if (sortBy.size() > 0) {
            sortBy.forEach((k, v) -> {
                if (k.equals("id")) k = "ID";
                if (k.equals("autofillText")) k = "C_AUTOFILL_TEXT";
                if (k.equals("cityIataCode")) k = "C_CITY_IATA_CODE";
                if (k.equals("cityName")) k = "C_CITY_NAME";
                if (k.equals("cityPersianName")) k = "C_CITY_PERSIAN_NAME";
                if (k.equals("countryCode")) k = "C_COUNTRY_CODE";
                if (k.equals("countryName")) k = "C_COUNTRY_NAME";
                if (k.equals("giataCode")) k = "N_GIATA_CODE";
                if (v.equals("ASCENDING"))
                    v = "asc";
                else
                    v = "desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), City.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<City> cities = query.getResultList();
        return cities;
    }
}

