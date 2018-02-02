package ru.itpark.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Film;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class FilmRepositoryImpl implements FilmRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Film> filmRowMapper;
    @Autowired
    public FilmRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        filmRowMapper = (rs, i)-> new Film(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("foto"),
                rs.getString("info"),
                rs.getString("genre"),
                rs.getFloat("rating"));
    }

    @Override
    public List<Film> findAll(){
        return jdbcTemplate.query("SELECT id, name, foto, info, genre, rating FROM films", filmRowMapper);
    }

    @Override
    public  Film findById(int id){
        return jdbcTemplate.queryForObject("SELECT id, name, foto, info, genre, rating FROM films WHERE id = :id",
                Map.of("id", id),
                filmRowMapper);
    }

    @Override
    public List<Film> findByNameContainingIgnoreCase(String name){
        return jdbcTemplate.query("SELECT id, name, foto, info, genre, rating FROM films WHERE name ILIKE :name",
                Map.of("name", name), filmRowMapper);
    }
}
