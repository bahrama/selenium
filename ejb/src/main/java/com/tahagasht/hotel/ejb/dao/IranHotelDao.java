package com.tahagasht.hotel.ejb.dao;

import com.tahagasht.hotel.ejb.model.IranHotel;
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
public class IranHotelDao {
    @PersistenceContext(unitName = "aliUnit")
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    public void save(IranHotel iranHotel) throws Exception {
        em.persist(iranHotel);
    }

    public int countIranHotel(Map<String, String> filterBy) {
        String q = "select count(*) as count from t_iran_hotel t \n";
        StringBuilder queryBuilder = new StringBuilder(q);
        if (filterBy.size() > 0) {
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k, v) -> {
                if (k.equals("id")) k = "ID";
                if (k.equals("pictureUrl")) k = "Picture_Url";
                if (k.equals("name")) k = "Name";
                if (k.equals("cityName")) k = "City_Name";
                if (k.equals("typeName")) k = "Type_Name";
                if (k.equals("gradeName")) k = "Grade_Name";
                if (k.equals("chainName")) k = "Chain_Name";
                if (k.equals("stateName")) k = "State_Name";
                if (k.equals("address")) k = "Address";
                if (k.equals("hotelRank")) k = "Hotel_Rank";
                if (k.equals("rankName")) k = "Rank_Name";
                if (k.equals("cityId")) k = "City_Id";
                if (k.equals("stateId")) k = "State_Id";
                if (k.equals("hasFreeTransfer")) k = "Has_Free_Transfer";
                if (k.startsWith("id")) queryBuilder.append(" and t." + k + "=" + v + "\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    public Optional<IranHotel> findIranHotelById(Long id) {
        IranHotel iranHotel = em.find(IranHotel.class, id);
        return iranHotel != null ? Optional.of(iranHotel) : Optional.empty();
    }

    public List<IranHotel> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from t_iran_hotel t\n";
        StringBuilder queryBuilder = new StringBuilder(q);
        if (filterBy.size() > 0) {
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k, v) -> {
                if (k.equals("id")) k = "ID";
                if (k.equals("pictureUrl")) k = "Picture_Url";
                if (k.equals("name")) k = "Name";
                if (k.equals("cityName")) k = "City_Name";
                if (k.equals("typeName")) k = "Type_Name";
                if (k.equals("gradeName")) k = "Grade_Name";
                if (k.equals("chainName")) k = "Chain_Name";
                if (k.equals("stateName")) k = "State_Name";
                if (k.equals("address")) k = "Address";
                if (k.equals("hotelRank")) k = "Hotel_Rank";
                if (k.equals("rankName")) k = "Rank_Name";
                if (k.equals("cityId")) k = "City_Id";
                if (k.equals("stateId")) k = "State_Id";
                if (k.equals("hasFreeTransfer")) k = "Has_Free_Transfer";
                if (k.startsWith("id")) queryBuilder.append(" and t." + k + "=" + v + "\n");
                else queryBuilder.append(" and lower(t." + k + ") like" + " lower('%" + v + "%') \n");
            });
        }
        if (sortBy.size() > 0) {
            sortBy.forEach((k, v) -> {
                if (k.equals("id")) k = "ID";
                if (k.equals("pictureUrl")) k = "Picture_Url";
                if (k.equals("name")) k = "Name";
                if (k.equals("cityName")) k = "City_Name";
                if (k.equals("typeName")) k = "Type_Name";
                if (k.equals("gradeName")) k = "Grade_Name";
                if (k.equals("chainName")) k = "Chain_Name";
                if (k.equals("stateName")) k = "State_Name";
                if (k.equals("address")) k = "Address";
                if (k.equals("hotelRank")) k = "Hotel_Rank";
                if (k.equals("rankName")) k = "Rank_Name";
                if (k.equals("cityId")) k = "City_Id";
                if (k.equals("stateId")) k = "State_Id";
                if (k.equals("hasFreeTransfer")) k = "Has_Free_Transfer";
                if (v.equals("ASCENDING"))
                    v = "asc";
                else
                    v = "desc";
                queryBuilder.append(" order by t." + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), IranHotel.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<IranHotel> hotels = query.getResultList();
        return hotels;
    }
}