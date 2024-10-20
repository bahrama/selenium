package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.DreamdaysHotel;
import com.tahagasht.hotel.ejb.model.HotelChannelead;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@LocalBean
@Stateless
public class DreamDaysHotelDao {
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    public int countDreamDaysHotel(Map<String, String> filterBy){
        String q = "select count(*) as count from dreamdays_hotel \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("hotelId")) k ="HotelId";
                if(k.equals("hotelName")) k ="HotelName";
                if(k.equals("latitude")) k ="Latitude";
                if(k.equals("longitude")) k ="Longitude";
                if(k.equals("address")) k ="Address";
                if(k.equals("rating")) k ="Rating";
                if(k.equals("countryId")) k ="CountryId";
                if(k.equals("countryName")) k ="CountryName";
                if(k.equals("cityId")) k ="CityId";
                if(k.equals("cityName")) k ="CityName";
                if(k.equals("giataId")) k ="GiataId";
                if(k.equals("hotelFrontImage")) k ="HotelFrontImage";
                if(k.equals("isRecomondedHotel")) k ="IsRecomondedHotel";
                if(k.equals("isActive")) k ="IsActive";
                if(k.equals("updatedDate")) k ="UpdatedDate";
                if(k.equals("ID")) queryBuilder.append(" and "+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(" + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }


    public Optional<DreamdaysHotel> findHotelById(Long id) throws Exception {
        String q = "select * from dreamdays_hotel t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        queryBuilder.append(" where t.id='" + id + "'");
        Query query = em.createNativeQuery(queryBuilder.toString(), DreamdaysHotel.class);
        DreamdaysHotel dreamdaysHotel = (DreamdaysHotel) query.getSingleResult();
        return dreamdaysHotel != null ? Optional.of(dreamdaysHotel):Optional.empty();
    }


    public List<DreamdaysHotel> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from dreamdays_hotel t\n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("hotelId")) k ="HotelId";
                if(k.equals("hotelName")) k ="HotelName";
                if(k.equals("latitude")) k ="Latitude";
                if(k.equals("longitude")) k ="Longitude";
                if(k.equals("address")) k ="Address";
                if(k.equals("rating")) k ="Rating";
                if(k.equals("countryId")) k ="CountryId";
                if(k.equals("countryName")) k ="CountryName";
                if(k.equals("cityId")) k ="CityId";
                if(k.equals("cityName")) k ="CityName";
                if(k.equals("giataId")) k ="GiataId";
                if(k.equals("hotelFrontImage")) k ="HotelFrontImage";
                if(k.equals("isRecomondedHotel")) k ="IsRecomondedHotel";
                if(k.equals("isActive")) k ="IsActive";
                if(k.equals("updatedDate")) k ="UpdatedDate";
                if(k.equals("ID")) queryBuilder.append(" and t."+ k +"=" + v  +"\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("id")) k ="ID";
                if(k.equals("hotelId")) k ="HotelId";
                if(k.equals("hotelName")) k ="HotelName";
                if(k.equals("latitude")) k ="Latitude";
                if(k.equals("longitude")) k ="Longitude";
                if(k.equals("address")) k ="Address";
                if(k.equals("rating")) k ="Rating";
                if(k.equals("countryId")) k ="CountryId";
                if(k.equals("countryName")) k ="CountryName";
                if(k.equals("cityId")) k ="CityId";
                if(k.equals("cityName")) k ="CityName";
                if(k.equals("giataId")) k ="GiataId";
                if(k.equals("hotelFrontImage")) k ="HotelFrontImage";
                if(k.equals("isRecomondedHotel")) k ="IsRecomondedHotel";
                if(k.equals("isActive")) k ="IsActive";
                if(k.equals("updatedDate")) k ="UpdatedDate";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), DreamdaysHotel.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<DreamdaysHotel> hotels = query.getResultList();
        return hotels;
    }
}
