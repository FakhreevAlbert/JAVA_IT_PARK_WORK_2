package ru.itpark.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Sale;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Sale> saleRowMapper;

    @Autowired
    public SaleRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        saleRowMapper = (rs, i)-> new Sale(rs.getInt("id"),
                rs.getString("manager_name"),
                rs.getString("product_name"),
                rs.getInt("sold_amount"),
                rs.getInt("price"));
    }

    @Override
    public List<Sale> findAll(){
        return jdbcTemplate.query("SELECT id, manager_name, product_name, sold_amount, price FROM sales",
                saleRowMapper);
    }

    @Override
    public Sale findByid(int id){
        return jdbcTemplate.queryForObject("SELECT id, manager_name, product_name, sold_amount, price FROM sales WHERE id = :id",
                Map.of("id", id),
                saleRowMapper);
    }

    @Override
    public List<Sale> findByNameContainingIgnoreCase(String name){
        return jdbcTemplate.query("SELECT id, manager_name, product_name, sold_amount, price FROM sales WHERE name ILIKE :name",
                Map.of("name", name), saleRowMapper);
    }

}
