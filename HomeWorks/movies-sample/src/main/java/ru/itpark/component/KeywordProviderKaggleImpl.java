package ru.itpark.component;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itpark.domain.Keyword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class KeywordProviderKaggleImpl implements KeywordProvider {

    private String keywordsCsv;


    @Value("${kaggle.keywords.csv}") // надо писать именно над setter'ом
    public void setKeywordsCsv(String keywordsCsv) {
        this.keywordsCsv = keywordsCsv;
    }

    @Override
    public void forEach(Consumer<? super Keyword> consumer) {
        try {
            CSVParser parser = CSVFormat
                    .RFC4180
                    .withHeader()
                    .withSkipHeaderRecord(true)
                    .parse(
                            Files.newBufferedReader(
                                    Paths.get(keywordsCsv)
                            )
                    );

            parser.forEach(record -> {
                Keyword keyword = null;
                try {
                    keyword = KeywordExtractor.extract(record);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                consumer.accept(keyword);
            });
        } catch (IOException e) {
            // TODO: retrow
            e.printStackTrace();
        }
    }

    static class KeywordExtractor {
        public static Keyword extract(CSVRecord record) {
            Map<String, String> map = record.toMap();

            int id = Integer.parseInt(map.get("id"), 10);
            String keywords = map.get("keywords");


            return new Keyword(
                    id, keywords
            );
        }
    }
}

