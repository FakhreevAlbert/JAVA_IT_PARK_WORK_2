package dao;


import java.util.List;

public interface BaseDao<T> {
    int save(T model);

    T find(int id);

    void update (T model);

    void delete(int id);

    List<T> findAll();

}
