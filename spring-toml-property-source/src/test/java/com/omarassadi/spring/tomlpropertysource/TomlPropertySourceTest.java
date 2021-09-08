/*
 * Copyright 2021 Omar Assadi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.omarassadi.spring.tomlpropertysource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
