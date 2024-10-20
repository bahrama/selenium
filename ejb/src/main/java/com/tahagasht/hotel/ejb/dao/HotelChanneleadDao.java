package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelChannelead;
import com.tahagasht.hotel.ejb.model.HotelMapping;
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
public class HotelChanneleadDao {

    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    public int countHotel(){
        String q = "select count(*) as count from t_hotel_channelead \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }


    public Optional<HotelChannelead> findHotelById(Long id) throws Exception {
        String q = "select * from t_hotel_channelead t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        queryBuilder.append(" where t.ID='" + id + "'");
        Query query = em.createNativeQuery(queryBuilder.toString(), HotelChannelead.class);
        HotelChannelead hotelChannelead = (HotelChannelead) query.getSingleResult();
        return hotelChannelead != null ? Optional.of(hotelChannelead):Optional.empty();
    }


    public List<HotelChannelead> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from t_hotel_channelead t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("cityId")) k ="city_id";
                if(k.equals("nameEn")) k ="name_en";
                if(k.equals("cityCode")) k ="city_code";
                if(k.equals("cityName")) k ="city_name";
                if(k.equals("imageUrl")) k ="image_url";
                if(k.equals("ID")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("cityId")) k ="city_id";
                if(k.equals("nameEn")) k ="name_en";
                if(k.equals("cityCode")) k ="city_code";
                if(k.equals("cityName")) k ="city_name";
                if(k.equals("imageUrl")) k ="image_url";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), HotelChannelead.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<HotelChannelead> hotels = query.getResultList();
        return hotels;
    }
}
