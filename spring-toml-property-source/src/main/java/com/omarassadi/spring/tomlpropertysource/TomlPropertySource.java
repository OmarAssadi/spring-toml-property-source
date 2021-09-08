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
