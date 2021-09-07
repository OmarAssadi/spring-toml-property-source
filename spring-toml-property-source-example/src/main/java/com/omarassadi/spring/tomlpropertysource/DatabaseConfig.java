package com.omarassadi.spring.tomlpropertysource;

import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Map;

@ConstructorBinding
public record DatabaseConfig(String address, String database, String username, String password, int port,
                             Map<String, Object> attributes) {

}
