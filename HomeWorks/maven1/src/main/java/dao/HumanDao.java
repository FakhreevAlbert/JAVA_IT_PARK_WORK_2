package dao;

import models.Human;

import java.util.List;


public interface HumanDao extends BaseDao<Human> {
    boolean isExistById(int humanId);
    List<Human> findByName(String name);
    List<Human> findBySurname(String surname);

}
