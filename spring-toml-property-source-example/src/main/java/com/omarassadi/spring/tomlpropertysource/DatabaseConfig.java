package com.omarassadi.spring.tomlpropertysource;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public final class DatabaseConfig {

    private String address;
    private String database;
    private String username;
    private String password;
    private int port;
    private Map<String, Object> attributes;
}
