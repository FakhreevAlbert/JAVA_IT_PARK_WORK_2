package ru.itpark.component;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.domain.Keyword;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class KeywordStorageSQLiteImpl implements KeywordStorage, InitializingBean, DisposableBean {


    private DataSource dataSource;
    private Connection connection;

    @Autowired
    public KeywordStorageSQLiteImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    // TODO: прочитать самсотоятельно
    public void afterPropertiesSet() throws SQLException {
        connection = dataSource.getConnection();
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS keywords;");
            stmt.execute("CREATE TABLE IF NOT EXISTS keywords ( id INTEGER PRIMARY KEY AUTOINCREMENT, keywords TEXT NOT NULL);");
        }
    }


    @Override
    // TODO: прочитать самостоятельно
    public void destroy() throws SQLException {
        connection.close();
    }

    @Override
    public void save(Keyword keyword) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO keywords ('id', 'keywords') VALUES (?, ?);")) {
            statement.setInt(1, keyword.getId());
            statement.setString(2, keyword.getKeywords());
            statement.execute();
        }
    }
}


