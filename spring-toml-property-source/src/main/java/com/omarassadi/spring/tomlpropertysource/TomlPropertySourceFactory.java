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
        if (!ClassUtils.isPresent("com.fasterxml.jackson.core.io.ContentReference", null)) {
            throw new IllegalStateException(
                "Attempted to load " + name + " but jackson-core was either not found on the classpath or below version 2.13.0");
        }
        final ObjectMapper mapper = new ObjectMapper(new TomlFactory());
        final Message<JsonNode> message = new GenericMessage<>(mapper.readTree(resource.getInputStream()));
        final ObjectToMapTransformer transformer = new ObjectToMapTransformer();
        transformer.setShouldFlattenKeys(true);
        final Map<String, Object> resultMap = (Map<String, Object>) transformer.transform(message).getPayload();
        return new OriginTrackedMapPropertySource(Optional.ofNullable(name).orElseGet(resource.getResource()::getFilename), resultMap);
    }
}
