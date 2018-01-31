package ru.itpark.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Manager;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class ManagerRepositoryImpl implements ManagerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Manager> managerRowMapper;

    @Autowired
    public ManagerRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        managerRowMapper = (rs, i) -> new Manager(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("salary"));
    }


    @Override
    public List<Manager> findAll() {
        return jdbcTemplate.query("SELECT id, name, salary FROM managers",
                managerRowMapper

        );

    }

    @Override
    public Manager findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, name, salary FROM managers WHERE id = :id",
                Map.of("id", id),
                managerRowMapper
        );
    }

    @Override
    public List<Manager> findByNameContainingIgnoreCase(String name) {
        return jdbcTemplate.query("SELECT id, name, salary FROM managers WHERE name ILIKE :name",
                Map.of("name", name), managerRowMapper);
    }
}

