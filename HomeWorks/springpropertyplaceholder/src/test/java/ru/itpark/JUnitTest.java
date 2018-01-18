package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.bean.Connector;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("JUnit functionality demo")
@ExtendWith(JUnitTest.InjectedServiceResolver.class)
public class JUnitTest {
    @Test
    @DisplayName("Bean should be not null")
    public void testSampleBean() {
        Connector connector = new ClassPathXmlApplicationContext("beans.xml").getBean(Connector.class);
        assertNotNull(connector, "Bean can't be null");
        assertEquals("admin", connector.getLogin(), "Must inject login value");

        Assertions.assertAll(
                () -> assertNotNull(connector, "Bean can't be null"),
                () -> assertEquals("admin", connector.getLogin(), "Must inject login value")
        );
    }

    @ParameterizedTest
    @MethodSource("getValues")
    @DisplayName("Test with parameters")
    public void testParametrized(int value) {
        assertEquals(0, value);
    }

    @Test
    @DisplayName("JUnit injection demo")
    public void testInjected(InjectedService service) {
        assertNotNull(service);
    }

    static IntStream getValues() {
        return IntStream.of(0, 0, 0, 0);
    }

    private static class InjectedService {

    }

    public static class InjectedServiceResolver implements ParameterResolver {

        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return InjectedService.class == parameterContext.getParameter().getType();
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return new InjectedService();
        }
    }
}
