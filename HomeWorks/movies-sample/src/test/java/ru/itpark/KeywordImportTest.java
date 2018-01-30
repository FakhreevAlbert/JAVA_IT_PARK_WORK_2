package ru.itpark;

import au.com.bytecode.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.component.KeywordImporter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringJUnitConfig(AppConfig.class)
@TestPropertySource(locations = {
        "classpath:app.properties",
        "classpath:test.properties"
})
public class KeywordImportTest {


    @Autowired // допустимо, т.к. это тест

    private KeywordImporter keywordImporter;


    @Test
    public void testKeywordImport() {
        KeywordImporter.KeywordResult keywordResult = keywordImporter.run();
        assertAll(
                () -> assertNotEquals(0, keywordResult.getProcessed()),
                () -> assertEquals(46419, keywordResult.getProcessed()),
                () -> assertNotEquals(0, keywordResult.getSucceed()),
                () -> assertEquals(keywordResult.getProcessed(), keywordResult.getSucceed() + keywordResult.getFailed())

        );

    }

    @Test
    public void testKeywordReader() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("data/keywords.csv"), ',', '"', 1);
        List<String[]> allRows = reader.readAll();
        for (String[] row : allRows) {
            System.out.println(Arrays.toString(row));
        }
    }
//SQL Language
    @Test
    public void testKeywordImportToDataBase() throws IOException {


        String csvFile = "data/keywords.csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";
        PreparedStatement statement = null;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            String[] array;
            int count = 0;
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/albert/Projects/MyWork/JAVA_IT_PARK_WORK_2/HomeWorks/movies-sample/data\\db.sqlite");
                while ((line = br.readLine()) != null)  // цикл построчного чтения
                {
                   count++;
                   if (count > 1) {
                        array = line.split(cvsSplitBy);
                        String query = "INSERT INTO keywords (id, keywords) VALUES ("+array[0]+", "+array[1]+")";


                        statement = connection.prepareStatement(query);
                        statement.executeUpdate();


                        System.out.println(array[0] + array[1]);

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            {
                if (br != null) {
                    br.close();
                }
            }
        }
    }
}

