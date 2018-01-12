package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.bean.Sample;

import java.util.stream.IntStream;

@DisplayName("JUnit functionality demo")
@ExtendWith(JUnitTest.InjectedServiceResolver.class)
public class JUnitTest {

    @Test
    @DisplayName("Bean should be not null")
    public void testSampleBean(){
        Sample sample = new ClassPathXmlApplicationContext("beans.xml").getBean(Sample.class);
        Assertions.assertNotNull(sample, "Bean can't be null");
        Assertions.assertEquals("Привет из РФ",sample.hello(),"Must inject value");
        Assertions.assertAll(
                ()->Assertions.assertNotNull(sample,"Bean cant't be null"),
                ()->Assertions.assertEquals("Привет из РФ", sample.hello(),"Must inject value")
        );

    }
      @ParameterizedTest
      @MethodSource("getValues")
      @DisplayName("Test with parameters")
      public void testParametrized(int value) {
          Assertions.assertEquals(0, value);
      }

      @Test
      @DisplayName("JUnit injection demo")
      public void testInjected(InjectedService service) {
         Assertions.assertNotNull(service);
      }

      static IntStream getValues() {
          return IntStream.of(0, 0, 0, 0);
     }

      private static class InjectedService {

      }

    public static class InjectedServiceResolver implements ParameterResolver{

        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return false;
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return null;
        }
    }
}

