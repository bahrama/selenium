package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.CullucCity;
import com.tahagasht.hotel.ejb.model.DreamdaysCity;
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
public class DreamDaysCityDao {

    @PersistenceContext(unitName = "aliUnit")
    private EntityManager em;

    public int countDreamDaysCity(){
        String q = "select count(*) as count from dreamdays_city \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    public Optional<DreamdaysCity> findDreamDaysCityById(Long id) {
        DreamdaysCity dreamdaysCity = em.find(DreamdaysCity.class , id);
        return dreamdaysCity != null ? Optional.of(dreamdaysCity):Optional.empty();
    }

    public List<DreamdaysCity> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from dreamdays_city t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("cityName")) k ="city_name";
                if(k.equals("cityCode")) k ="city_code";
                if(k.equals("ID")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("cityName")) k ="city_name";
                if(k.equals("cityCode")) k ="city_code";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), DreamdaysCity.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<DreamdaysCity> cities = query.getResultList();
        return cities;
    }
}
