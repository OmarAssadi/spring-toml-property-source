package com.omarassadi.spring.tomlpropertysource;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@ConfigurationPropertiesBinding
public final class StringToLocaleConverter implements Converter<String, Locale> {

    @Override
    public Locale convert(final String s) {
        return Locale.forLanguageTag(s);
    }
}
