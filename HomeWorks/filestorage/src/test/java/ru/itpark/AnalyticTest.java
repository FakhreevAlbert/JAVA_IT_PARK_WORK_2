package ru.itpark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.component.Analytic;
import ru.itpark.exception.AnalyticException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(JavaConfig.class)
class AnalyticTest {
    @Autowired
    private Analytic analytic;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testAnalyticInjection() {
        assertNotNull(analytic);
    }

    //   @Test
    //   public void testWhenNoUsers() {
    //      int result = analytic.getUsersCount();

    //       assertEquals(0, result);
    //   }

    @Test
    public void testWhenSomeUserExists() throws SQLException {
        createUsers();

        int result = analytic.getUsersCount();
        assertEquals(6, result);

        deleteUsers();
        getUsersCount();

    }

    private void createUsers() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("INSERT INTO users (id, login, name) VALUES\n" +
                        "  (5, 'vasya', 'vasya'),\n" +
                        "  (6, 'petya', 'petya');");
            }
        }
    }

    private void deleteUsers() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("DELETE FROM users WHERE id = 5");
                statement.execute("DELETE FROM users WHERE id = 6");
            }
        }
    }
    public int getUsersCount() {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeQuery("SELECT count(*) FROM users");
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();

                return resultSet.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AnalyticException(e);
        }
    }

//    public List<Object> getUsersCount() {
//        int count = 0;
//        int userId = 0;
//        String name = null;
//        List<Integer> usersIdArray = new ArrayList<>();
//        List<Integer> filesCountPerUser = new ArrayList<>();
//        List<Object> list = new ArrayList<>();
//
//
//        try (Connection connection1 = dataSource.getConnection()) {
//            try (Statement statement1 = connection1.createStatement()) {
//                statement1.executeQuery("SELECT * FROM files");
//                ResultSet resultSet1 = statement1.getResultSet();
//
//                while (resultSet1.next()) {
//
//                    usersIdArray.add(resultSet1.getInt(4));
//
//
//                }
//
//                for (int i = 0; i < usersIdArray.size(); i++) {
//                    for (int j =1; j < (usersIdArray.size()-1) ; j++) {
//                        if ((usersIdArray.get(i) == usersIdArray.get(j)) & (i == 0)){
//                            userId = usersIdArray.get(j);
//                            count++;
//
//                        }
//                        if (i >0 & (usersIdArray.get(i) == usersIdArray.get(j))){
//
//
//                        }
//
//                    }
//
//                    System.out.println(usersIdArray.get(i));
//                }
//
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new AnalyticException(e);
//        }
//
//        try (Connection connection = dataSource.getConnection()) {
//            try (Statement statement = connection.createStatement()) {
//                statement.executeQuery("SELECT * FROM files");
//                ResultSet resultSet = statement.getResultSet();
//
//                while (resultSet.next()) {
//                    filesCountPerUser.add(resultSet.getInt(4));
//
//                }
//            }
//
////            for (int i = 0; i < ; i++){
////
////            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new AnalyticException(e);
//        } return list;
//    }







}