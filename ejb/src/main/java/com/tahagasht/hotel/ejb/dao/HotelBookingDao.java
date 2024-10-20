package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.Hotel;
import com.tahagasht.hotel.ejb.model.HotelBooking;
import com.tahagasht.hotel.ejb.model.HotelMapping;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Stateless
@LocalBean
public class HotelBookingDao {
    @PersistenceContext(unitName="aliUnit")
    protected EntityManager em;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void save(HotelBooking hotelBooking){
        try {
            //em.persist(hotelBooking);
            String q = "insert into t_hotel_booking_com (t_city_name,t_country_code,c_description,c_facility,c_hotel_name,lat,lng) values(?,?,?,?,?,?,?)\n";
            StringBuilder queryBuilder = new StringBuilder(q);
            em.createNativeQuery(queryBuilder.toString())
                    .setParameter(1,hotelBooking.getCityName())
                    .setParameter(2,hotelBooking.getCountryCode())
                    .setParameter(3,hotelBooking.getDescription())
                    .setParameter(4,hotelBooking.getFicility())
                    .setParameter(5,hotelBooking.getHotelName())
                    .setParameter(6,hotelBooking.getLat())
                    .setParameter(7,hotelBooking.getLng())
                    .executeUpdate();
           // HotelBooking hotelMapping = (HotelBooking) query.getSingleResult();
        }catch (Exception e){
            System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        }
    }

    public Optional<HotelBooking> findHotelBookingByName(String hotelName) throws Exception {
        try {
            String q = "select * from t_hotel_booking_com t\n";
            StringBuilder queryBuilder = new StringBuilder(q);
            queryBuilder.append(" where t.c_hotel_name=\'" + hotelName + "\'");
            Query query = em.createNativeQuery(queryBuilder.toString(), HotelBooking.class);
            HotelBooking hotelMapping = (HotelBooking) query.getSingleResult();
            return hotelMapping != null ? Optional.of(hotelMapping) : Optional.empty();
        }catch (Exception e){
            throw new Exception();
        }
    }


    public List<HotelBooking> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from t_hotel_booking_com t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("hotelName")) k ="c_hotel_name";
                if(k.equals("ficility")) k ="c_facility";
                if(k.equals("description")) k ="c_description";
                if(k.equals("lat")) k ="lat";
                if(k.equals("lng")) k ="lng";
                if(k.equals("ID")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else if(k.equals("lat")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else if(k.equals("lng")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("hotelName")) k ="c_hotel_name";
                if(k.equals("ficility")) k ="c_facility";
                if(k.equals("description")) k ="c_description";
                if(k.equals("lat")) k ="lat";
                if(k.equals("lng")) k ="lng";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), HotelBooking.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<HotelBooking> hotels = query.getResultList();
        return hotels;
    }

    public List<Object> findHotelBookingMatch(){
        String q = "SELECT * from t_hotel_booking_com ";
        StringBuilder queryBuilder =new StringBuilder(q);
        Query query = em.createNativeQuery(queryBuilder.toString(),Object.class);
        List<Object> meetings = query.getResultList();
        return meetings;
    }


}
