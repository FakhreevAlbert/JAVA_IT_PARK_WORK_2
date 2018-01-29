package ru.itpark.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class KeywordImporterImpl implements KeywordImporter {
    private KeywordProvider keywordProvider;
    private KeywordStorage keywordStorage;

    @Autowired
    public KeywordImporterImpl(KeywordProvider keywordProvider, KeywordStorage keywordStorage) {
        this.keywordProvider = keywordProvider;
        this.keywordStorage = keywordStorage;
    }

    @Override
    public KeywordResult run() {
        KeywordResult result = new KeywordResult();
        keywordProvider.forEach(keyword -> {
            result.incProcessed();
            if (keyword != null) {
                try {
                    keywordStorage.save(keyword);
                    result.incSucceed();
                } catch (SQLException e) {
                    result.incFailed();
                    e.printStackTrace();
                }
            } else {
                result.incFailed();
            }
        });

        return result;
    }
}
