package ru.itpark.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Product;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class ProductReposytoryImpl implements ProductReposytory {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Product> productRowMapper;

    @Autowired
    public ProductReposytoryImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        productRowMapper = (rs, i) -> new Product(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getInt("amount"));
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT id, name, price, amount FROM goods", productRowMapper);
    }

    @Override
    public Product findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name, price, amount FROM goods WHERE id = :id",
                Map.of("id", id), productRowMapper);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        return jdbcTemplate.query("SELECT id, name, price, amount FROM goods WHERE name ILIKE :name",
                Map.of("name", name), productRowMapper);
    }
}
