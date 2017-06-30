package dao;

import models.Human;

import java.util.List;


public interface HumanDao extends BaseDao<Human> {
    boolean isExistById(int humanId);

    public void findByName(String name);
    public void findBySurname(String surname);

}
