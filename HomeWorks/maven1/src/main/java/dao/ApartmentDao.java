package dao;

import models.Apartment;
import models.Human;

import java.util.List;


public interface ApartmentDao extends BaseDao<Apartment> {

    List<Apartment> findByNumber(int number);
    List<Apartment> findByArea(int area);

}
