package dao;

import models.Apartment;
import models.Human;

import java.util.List;


public interface ApartmentDao extends BaseDao<Apartment> {

    public void findByNumber(int number);
    public void findByArea(int area);

}
