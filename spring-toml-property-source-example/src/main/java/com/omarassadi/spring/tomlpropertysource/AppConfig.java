package com.omarassadi.spring.tomlpropertysource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@ConstructorBinding
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app-config")
public record AppConfig(String websiteName, URI baseUrl, Locale locale, List<String> modules,
                        List<DatabaseConfig> databases) {

}
