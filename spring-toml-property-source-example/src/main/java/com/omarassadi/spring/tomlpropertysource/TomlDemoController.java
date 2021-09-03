package com.omarassadi.spring.tomlpropertysource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@TomlPropertySource(value = "classpath:test.toml")
public final class TomlDemoController {

    private final AppConfig appConfig;

    @Value("${topLevelKey}")
    private String topLevelString;

    @Value("${table.tableKey}")
    private String tableString;

    @GetMapping("/api/config")
    AppConfig getConfig() {
        return appConfig;
    }

    @GetMapping("/api/toplevel")
    String getTopLevelString() {
        return topLevelString;
    }

    @GetMapping("/api/table")
    public String getTableString() {
        return tableString;
    }
}
