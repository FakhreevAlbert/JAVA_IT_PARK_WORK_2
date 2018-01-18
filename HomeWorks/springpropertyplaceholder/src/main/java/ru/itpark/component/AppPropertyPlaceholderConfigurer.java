package ru.itpark.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

/**
 * Created by worker on 12/17/17.
 */
@Component
public class AppPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    public AppPropertyPlaceholderConfigurer() throws MalformedURLException {
        setLocation(new FileUrlResource("connector.properties"));
    }
}
