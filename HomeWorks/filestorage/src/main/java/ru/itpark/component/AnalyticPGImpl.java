package ru.itpark.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.exception.AnalyticException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnalyticPGImpl implements Analytic {

    private DataSource dataSource;

    @Autowired
    public AnalyticPGImpl(DataSource dataSource) {
        this.dataSource = dataSource;
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

    //SQL language
    public int getFilesSize() {

        int totalSize = 0;
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeQuery("SELECT * FROM files");
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    totalSize = totalSize + resultSet.getInt(3);
                }
                return totalSize;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AnalyticException(e);
        }


    }
    public int getFilesCount() {
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeQuery("SELECT count(*) FROM files");
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();

                return resultSet.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AnalyticException(e);
        }
    }


    public float getFilesCountPerUser() {
        float averageFilesCountPerUser = getFilesCount() / getUsersCount();

        return averageFilesCountPerUser;
    }

    public double getAverageFileSizePerUser(){
        double averageFileSizePerUser = getFilesSize() / getUsersCount();

        return averageFileSizePerUser;
    }

    public List<Object> getMaxSizeFilePerUser() {
        int max = 0;
        int userId = 0;
        String name = null;
        List<Object> list = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeQuery("SELECT * FROM files");
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    if (resultSet.getInt(3) > max) {
                        max = resultSet.getInt(3);
                        userId = resultSet.getInt(4);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new AnalyticException(e);
            }
            try (Connection connection1 = dataSource.getConnection()) {
                try (Statement statement1 = connection1.createStatement()) {
                    statement1.executeQuery("SELECT * FROM users");
                    ResultSet resultSet1 = statement1.getResultSet();
                    while (resultSet1.next()) {
                        if (resultSet1.getInt(1) == userId) {
                            name = resultSet1.getString(3);
                        }
                    }
                    list.add(name);
                    list.add(max);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new AnalyticException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
