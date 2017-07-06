package dao;



import models.Human;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HumanDaoJdbcTemplateImpl implements HumanDao{

    //language=SQL
    private final static String SQL_SELECT_ALL_HUMANS =
            "SELECT * FROM humans";
    //language=SQL
    private final static String SQL_SELECT_ALL_HUMANS_BY_NAME =
            "SELECT * FROM humans WHERE name = ?";
    //language=SQL
    private final static String SQL_SELECT_ALL_HUMANS_BY_SURNAME =
            "SELECT * FROM humans WHERE surname = ?";

    //language=SQL
    private final static String SQL_UPDATE_HUMAN =
            "UPDATE humans SET name = ?, surname = ? WHERE id = ?";

    //language=SQL
    private final static String SQL_INSERT_HUMAN =
            "INSERT INTO humans(name, surname) VALUES(?, ?)";

    //language=SQL
    private final static String SQL_SELECT_BY_ID =
            "SELECT * FROM humans WHERE id = ?";
    //language=SQL
    private final static String SQL_DELETE_BY_ID =
            "DELETE FROM humans WHERE id = ?";

    private JdbcTemplate template;

    public HumanDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    public boolean isExistById(int humanId) {
        return false;
    }

    public List<Human> findByName(String name) {

        return template.query(SQL_SELECT_ALL_HUMANS_BY_NAME, humanRowMapper, name);
    }

    public List<Human> findBySurname(String surname) {
        return template.query(SQL_SELECT_ALL_HUMANS_BY_SURNAME, humanRowMapper, surname);
    }

    public int save(Human model) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(template);
        jdbcInsert.withTableName("humans").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", model.getName());
        params.put("surname", model.getSurname());

        int id = jdbcInsert.executeAndReturnKey(params).intValue();
        model.setId(id);
        return id;
    }

    public Human find(int id) {
        return template.queryForObject(SQL_SELECT_BY_ID, humanRowMapper, id);
    }

    public void update(Human model) {
        template.update(SQL_UPDATE_HUMAN, model.getName(), model.getSurname(), model.getId());
    }

    public void delete(int id) {
        template.query(SQL_DELETE_BY_ID, humanRowMapper, id);
    }

    private RowMapper<Human> humanRowMapper = new RowMapper<Human>() {
        public Human mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");

            return new Human(name, surname);
        }
    };

    public List<Human> findAll() {
        return template.query(SQL_SELECT_ALL_HUMANS, humanRowMapper);
    }


    }



