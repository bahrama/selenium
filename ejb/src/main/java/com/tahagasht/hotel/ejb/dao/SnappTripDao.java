package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import com.tahagasht.hotel.ejb.model.SnappTrip;
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
public class SnappTripDao {
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    public void save(SnappTrip snappTrip) throws Exception {
        em.persist(snappTrip);
    }

    public int countSnappTrip(Map<String, String> filterBy){
        String q = "select count(*) as count from t_snapp_trip t \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("hotelCode")) k ="hotel_code";
                if(k.equals("nothing")) k ="nothing";
                if(k.equals("hotelName")) k ="hotel_name";
                if(k.equals("hotelType")) k ="hotel_type";
                if(k.equals("cityCode")) k ="city_code";
                if(k.equals("cityName")) k ="city_name";
                if(k.startsWith("hotelCode")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    public Optional<SnappTrip> findSnappTripById(Long id) {
        SnappTrip snappTrip = em.find(SnappTrip.class , id);
        return snappTrip != null ? Optional.of(snappTrip):Optional.empty();
    }

    public List<SnappTrip> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from t_snapp_trip t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("hotelCode")) k ="hotel_code";
                if(k.equals("nothing")) k ="nothing";
                if(k.equals("hotelName")) k ="hotel_name";
                if(k.equals("hotelType")) k ="hotel_type";
                if(k.equals("cityCode")) k ="city_code";
                if(k.equals("cityName")) k ="city_name";
                if(k.startsWith("hotelCode")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("hotelCode")) k ="hotel_code";
                if(k.equals("nothing")) k ="nothing";
                if(k.equals("hotelName")) k ="hotel_name";
                if(k.equals("hotelType")) k ="hotel_type";
                if(k.equals("cityCode")) k ="city_code";
                if(k.equals("cityName")) k ="city_name";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), SnappTrip.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<SnappTrip> hotels = query.getResultList();
        return hotels;
    }

}
