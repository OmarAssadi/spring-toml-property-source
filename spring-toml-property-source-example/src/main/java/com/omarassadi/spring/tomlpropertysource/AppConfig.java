package com.omarassadi.spring.tomlpropertysource;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties("app-config")
public class AppConfig {

    private String websiteName;
    private URI baseUrl;
    private Locale locale;
    private List<String> modules;
    private List<DatabaseConfig> databases;
}
