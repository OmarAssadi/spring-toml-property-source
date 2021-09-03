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
