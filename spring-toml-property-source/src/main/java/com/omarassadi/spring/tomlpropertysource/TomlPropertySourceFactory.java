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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.integration.transformer.ObjectToMapTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public final class TomlPropertySourceFactory implements PropertySourceFactory {

    @Override
    @SuppressWarnings("unchecked")
    public PropertySource<?> createPropertySource(final String name, final EncodedResource resource) throws IOException {
        if (!ClassUtils.isPresent("com.fasterxml.jackson.dataformat.toml.TomlFactory", null)) {
            throw new IllegalStateException(
                "Attempted to load " + name + " but jackson-dataformat-toml was not found on the classpath");
        }
        final ObjectMapper mapper = new ObjectMapper(new TomlFactory());
        final Message<JsonNode> message = new GenericMessage<>(mapper.readTree(resource.getInputStream()));
        final ObjectToMapTransformer transformer = new ObjectToMapTransformer();
        transformer.setShouldFlattenKeys(true);
        final Map<String, Object> resultMap = (Map<String, Object>) transformer.transform(message).getPayload();
        return new OriginTrackedMapPropertySource(Optional.ofNullable(name).orElseGet(resource.getResource()::getFilename), resultMap);
    }
}
