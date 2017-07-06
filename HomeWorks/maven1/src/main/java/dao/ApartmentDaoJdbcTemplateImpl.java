package dao;

import models.Apartment;
import models.Human;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ApartmentDaoJdbcTemplateImpl implements ApartmentDao {
    //language=SQL
    private final static String SQL_SELECT_ALL_APARTMENTS =
            "SELECT * FROM apartments";
    //language=SQL
    private final static String SQL_SELECT_ALL_APARTMENTS_BY_NUMBER =
            "SELECT * FROM apartments WHERE number = ?";
    //language=SQL
    private final static String SQL_SELECT_ALL_APARTMENTS_BY_AREA =
            "SELECT * FROM apartments WHERE area = ?";

    //language=SQL
    private final static String SQL_UPDATE_APARTMENT =
            "UPDATE apartments SET number = ?, area = ? WHERE id = ?";

    //language=SQL
    private final static String SQL_INSERT_APARTMENT =
            "INSERT INTO apartments(number, area) VALUES(?, ?)";

    //language=SQL
    private final static String SQL_SELECT_BY_ID =
            "SELECT * FROM apartments WHERE id = ?";
    //language=SQL
    private final static String SQL_DELETE_BY_ID =
            "DELETE  FROM apartments WHERE id = ?";

    private JdbcTemplate template;

    public ApartmentDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public int save(Apartment model) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(template);
        jdbcInsert.withTableName("apartments").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", model.getId());
        params.put("number", model.getNumber());
        params.put("area", model.getArea());
        params.put("ownerId", model.getOwnerId());

        int id = jdbcInsert.executeAndReturnKey(params).intValue();
        model.setId(id);
        return id;

    }

    @Override
    public Apartment find(int id) {
        return template.queryForObject(SQL_SELECT_BY_ID, apatmentRowMapper, id);
    }

    public void update(Apartment model) {
        template.update(SQL_UPDATE_APARTMENT, model.getId(), model.getNumber(),
                model.getArea(), model.getOwnerId());

    }


    public void delete(int id) {
        template.query(SQL_DELETE_BY_ID, apatmentRowMapper, id);

    }
    private RowMapper<Apartment> apatmentRowMapper = new RowMapper<Apartment>() {
        public Apartment mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            int number = resultSet.getInt("number");
            int area = resultSet.getInt("area");
            int ownerId = resultSet.getInt("ownerId");

            return new Apartment(number, area, ownerId);
        }
    };

    @Override
    public List<Apartment> findAll() {
        return template.query(SQL_SELECT_ALL_APARTMENTS, apatmentRowMapper);
    }


    public List<Apartment> findByNumber(int number) {
    return template.query(SQL_SELECT_ALL_APARTMENTS_BY_NUMBER, apatmentRowMapper, number);
    }


    public List<Apartment> findByArea(int area) {
      return template.query(SQL_SELECT_ALL_APARTMENTS_BY_AREA, apatmentRowMapper, area);
    }
}


