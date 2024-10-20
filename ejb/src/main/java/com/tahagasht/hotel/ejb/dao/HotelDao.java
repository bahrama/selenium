package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelBooking;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Provider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Stateless
@LocalBean
public class HotelDao {
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    public void save(Hotel hotel) throws Exception {
        em.persist(hotel);
    }

    public int countHotel(Map<String, String> filterBy){
        String q = "select count(*) as count from t_hotel t \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("name")) k ="C_NAME";
                if(k.equals("cityName")) k ="C_CITY_NAME";
                if(k.equals("countryCode")) k ="C_COUNTRY_CODE";
                if(k.equals("giataCode")) k ="N_GIATA_CODE";
                if(k.equals("latitude")) k ="N_LATITUDE";
                if(k.equals("longitude")) k ="N_LONGITUDE";
                if(k.equals("addresses")) k ="C_ADDRESSES";
                if(k.equals("persianName")) k ="C_PERSIAN_NAME";
                if(k.startsWith("N") || k.equals("ID")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    public Optional<Hotel> findHotelById(Long id) {
        Hotel hotel = em.find(Hotel.class , id);
        return hotel != null ? Optional.of(hotel):Optional.empty();
    }

    public List<Tuple> findHotelByNameOrLatAndLng(String hotelName,double lat,double lng){
        /*String q = "select th.id,th.c_name from t_hotel th\n" +
                "where lower(th.c_name) = lower('Harcourt') or (trunc(th.n_latitude,4) = 53.3344 and trunc(th.n_longitude,4) =-6.2628);";*/
        String q = "select th.id,th.c_name from t_hotel th where \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        queryBuilder.append("lower(th.c_name) = lower('"+hotelName +"')\n");
        queryBuilder.append("or ((trunc(th.n_latitude,4) =trunc(" + lat +",4))  and (trunc(th.n_longitude,4) = trunc("+lng+",4)));");
        Query query = em.createNativeQuery(queryBuilder.toString(), Hotel.class);
        List<Tuple> hotels = query.getResultList();
        return hotels;
    }


    public List<Hotel> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from t_hotel t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("name")) k ="C_NAME";
                if(k.equals("cityName")) k ="C_CITY_NAME";
                if(k.equals("countryCode")) k ="C_COUNTRY_CODE";
                if(k.equals("giataCode")) k ="N_GIATA_CODE";
                if(k.equals("latitude")) k ="N_LATITUDE";
                if(k.equals("longitude")) k ="N_LONGITUDE";
                if(k.equals("addresses")) k ="C_ADDRESSES";
                if(k.equals("persianName")) k ="C_PERSIAN_NAME";
                if(k.startsWith("N") || k.equals("ID")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("name")) k ="C_NAME";
                if(k.equals("cityName")) k ="C_CITY_NAME";
                if(k.equals("countryCode")) k ="C_COUNTRY_CODE";
                if(k.equals("giataCode")) k ="N_GIATA_CODE";
                if(k.equals("latitude")) k ="N_LATITUDE";
                if(k.equals("longitude")) k ="N_LONGITUDE";
                if(k.equals("addresses")) k ="C_ADDRESSES";
                if(k.equals("persianName")) k ="C_PERSIAN_NAME";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), Hotel.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<Hotel> hotels = query.getResultList();
        return hotels;
    }
}
