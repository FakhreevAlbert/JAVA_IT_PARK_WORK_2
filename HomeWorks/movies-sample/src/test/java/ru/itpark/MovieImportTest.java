package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.itpark.component.KeywordImporter;
import ru.itpark.component.MoviesImporter;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(AppConfig.class)
@TestPropertySource(locations = {
    "classpath:app.properties",
    "classpath:test.properties"
})
public class MovieImportTest {
  @Autowired // допустимо, т.к. это тест
  private MoviesImporter importer;


  @Test
  public void testImport() {
    MoviesImporter.Result result = importer.run();
    assertAll(
        () -> assertNotEquals(0, result.getProcessed()),
        () -> assertEquals(45466, result.getProcessed()),
        () -> assertNotEquals(0, result.getSucceed()),
        () -> assertEquals(result.getProcessed(), result.getSucceed() + result.getFailed())
    );

  }




}
