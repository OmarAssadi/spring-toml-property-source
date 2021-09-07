package com.omarassadi.spring.tomlpropertysource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;


public class TomlDemoApplicationTest {

    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setUp() {
        context = SpringApplication.run(TomlDemoApplication.class);
    }

    @AfterEach
    public void tearDown() {
        context.close();
    }

    @Test
    public void appStartsAndReturnsConfig() {
        final WebClient client = WebClient.create();
        final String result = client.get().uri("http://localhost:8085/api/config").retrieve()
            .bodyToMono(String.class)
            .block();
        assertThat(result, sameJSONAs("{\"baseUrl\":\"https://localhost/\",\"locale\":\"en-us\",\"modules\":[\"game\",\"forum\"],\"websiteName\":\"Spring TOML Demo\",\"databases\":[{\"address\":\"localhost\",\"database\":\"forum_db\",\"password\":\"123456\",\"port\":3306,\"username\":\"forum_user\",\"attributes\":{\"serverTimezone\":\"GMT\",\"testAttrib\":4151,\"useSSL\":true}},{\"address\":\"127.0.0.1\",\"database\":\"game_db\",\"password\":\"hunter2\",\"port\":43594,\"username\":\"game_user\",\"attributes\":{\"mode\":1,\"serverTimezone\":\"UTC\",\"useSSL\":false}}]}"));
    }
}
