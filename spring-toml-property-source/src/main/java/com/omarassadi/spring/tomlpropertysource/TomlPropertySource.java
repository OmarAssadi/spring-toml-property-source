package com.omarassadi.spring.tomlpropertysource;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@PropertySource(value = "", factory = TomlPropertySourceFactory.class)
public @interface TomlPropertySource {

    /**
     * @see PropertySource#name()
     */
    @AliasFor(annotation = PropertySource.class)
    String name() default "";

    /**
     * @see PropertySource#value()
     */
    @AliasFor(annotation = PropertySource.class)
    String[] value();

    /**
     * @see PropertySource#ignoreResourceNotFound()
     */
    @AliasFor(annotation = PropertySource.class)
    boolean ignoreResourceNotFound() default false;

    /**
     * @see PropertySource#encoding()
     */
    @AliasFor(annotation = PropertySource.class)
    String encoding() default "";
}
