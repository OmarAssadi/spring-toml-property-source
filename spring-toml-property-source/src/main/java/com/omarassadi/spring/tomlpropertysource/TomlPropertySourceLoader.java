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

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class TomlPropertySourceLoader implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"tml", "toml"};
    }

    @Override
    public List<PropertySource<?>> load(final String name, final Resource resource) throws IOException {
        final EncodedResource encodedResource = new EncodedResource(resource);
        return Collections.singletonList(new TomlPropertySourceFactory().createPropertySource(name, encodedResource));
    }
}
