import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
import ru.itpark.bean.Connector

beans {
    propertyPlaceholderConfigurer(PropertyPlaceholderConfigurer) {
        location = 'file:connector.properties'
    }

    connector(Connector) {
        login = '${connector.login}'
        password = '${connector.password}'
    }
}