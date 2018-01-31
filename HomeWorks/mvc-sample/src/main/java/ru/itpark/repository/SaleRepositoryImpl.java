package ru.itpark.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Sale;

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
        saleRowMapper = (rs, i) -> new Sale(rs.getInt("id"),
                rs.getString("manager"),
                rs.getString("product"),
                rs.getInt("sold"),
                rs.getInt("price"));
    }

    @Override
    public List<Sale> findAll() {
        return jdbcTemplate.query("SELECT id, manager, product, sold, price FROM sales",
                saleRowMapper);
    }

    @Override
    public Sale findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, manager, product, sold, price FROM sales WHERE id = :id",
                Map.of("id", id),
                saleRowMapper);
    }

    @Override
    public List<Sale> findByNameContainingIgnoreCase(String manager) {
        return jdbcTemplate.query("SELECT id, manager, product, sold, price FROM sales WHERE manager ILIKE :manager",
                Map.of("manager", manager), saleRowMapper);
    }

}
