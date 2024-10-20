package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.SnappTripCity;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Stateless
@LocalBean
public class SnappTripCityDao {
    @PersistenceContext(unitName = "aliUnit")
    private EntityManager em;

    public int countSnappTripCity(Map<String, String> filterBy){
        String q = "select count(*) as count from t_snapp_trip_city \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    public Optional<SnappTripCity> findSnappTripCityById(Long id) {
        SnappTripCity snappTripCity = em.find(SnappTripCity.class , id);
        return snappTripCity != null ? Optional.of(snappTripCity):Optional.empty();
    }

    public List<SnappTripCity> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from t_snapp_trip_city t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("name")) k ="name";
                if(k.equals("title")) k ="title";
                if(k.equals("description")) k ="description";
                if(k.equals("stateId")) k ="state_id";
                if(k.equals("stateTitle")) k ="state_title";
                if(k.equals("ID")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("name")) k ="name";
                if(k.equals("title")) k ="title";
                if(k.equals("description")) k ="description";
                if(k.equals("stateId")) k ="state_id";
                if(k.equals("stateTitle")) k ="state_title";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), SnappTripCity.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<SnappTripCity> cities = query.getResultList();
        return cities;
    }
}
