package ru.itpark.component;

import ru.itpark.domain.Keyword;

import java.sql.SQLException;

public interface KeywordStorage {
    void save(Keyword keyword) throws SQLException;
}
