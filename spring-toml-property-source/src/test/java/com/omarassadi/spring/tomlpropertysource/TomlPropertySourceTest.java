package com.omarassadi.spring.tomlpropertysource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TomlPropertySourceTest {

    @Autowired
    private Environment environment;

    @Test
    public void topLevelPropertiesWork() {
        assertThat(environment.getProperty("topLevelKey"), is("top level value"));
        assertThat(environment.getProperty("2ndTopLevelKey"), is("2nd top level value"));
    }

    @Test
    public void tablePropertiesWork() {
        assertThat(environment.getProperty("table.tableKey"), is("table value"));
    }

    @Test
    public void listsWork() {
        assertThat(environment.getProperty("table.listWithItems[0]"), is("string Item"));
        assertThat(environment.getProperty("table.listWithItems[1]"), is("123"));
        assertThat(environment.getProperty("table.listWithItems[2]"), is("false"));
    }

    @SpringBootApplication
    @TomlPropertySource("classpath:annotationtest.toml")
    static class TestSpringApplication {

    }
}
