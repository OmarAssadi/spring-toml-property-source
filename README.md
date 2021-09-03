# Spring TOML Property Source

This project adds support for TOML in Spring Boot configs.

* [spring-toml-property-source]() contains the actual library
* [spring-toml-property-source-example]() contains a demo Spring application that makes use of the library

## Usage

1. Add the library as a dependency. I plan to clean this up a bit and publish it to Maven Central soon.
2. Create a file in `META-INF/` called `spring.factories` and add the following:

```properties
org.springframework.boot.env.PropertySourceLoader=com.omarassadi.spring.tomlpropertysource.TomlPropertySourceLoader
```
