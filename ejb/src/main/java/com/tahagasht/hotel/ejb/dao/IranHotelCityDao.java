package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.IranHotel;
import com.tahagasht.hotel.ejb.model.IranHotelCity;
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
public class IranHotelCityDao {
    @PersistenceContext(unitName = "aliUnit")
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    public void save(IranHotelCity iranHotelCity) throws Exception {
        em.persist(iranHotelCity);
    }

    public int countIranHotelCity(Map<String, String> filterBy) {
        String q = "select count(*) as count from t_iran_hotel_city t \n";
        StringBuilder queryBuilder = new StringBuilder(q);
        if (filterBy.size() > 0) {
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k, v) -> {
                if (k.equals("id")) k = "ID";
                if (k.equals("title")) k = "title";
                if (k.startsWith("id")) queryBuilder.append(" and t." + k + "=" + v + "\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    public Optional<IranHotelCity> findIranHotelCityById(Long id) {
        IranHotelCity iranHotelCity = em.find(IranHotelCity.class, id);
        return iranHotelCity != null ? Optional.of(iranHotelCity) : Optional.empty();
    }

    public List<IranHotelCity> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from t_iran_hotel_city t\n";
        StringBuilder queryBuilder = new StringBuilder(q);
        if (filterBy.size() > 0) {
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k, v) -> {
                if (k.equals("id")) k = "ID";
                if (k.equals("title")) k = "title";
                if (k.startsWith("id")) queryBuilder.append(" and t." + k + "=" + v + "\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if (sortBy.size() > 0) {
            sortBy.forEach((k, v) -> {
                if (k.equals("id")) k = "ID";
                if (k.equals("title")) k = "title";
                if (v.equals("ASCENDING"))
                    v = "asc";
                else
                    v = "desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), IranHotelCity.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<IranHotelCity> hotels = query.getResultList();
        return hotels;
    }
}
