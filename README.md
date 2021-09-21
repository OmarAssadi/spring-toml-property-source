<p style="text-align: center;">
  <a href="README_zh.md">中文版请阅此处</a>
</p>

# Spring TOML Property Source

Spring TOML Property Source adds support loading TOML-based configuration files in your
Spring Boot applications.

This project is divided up into two parts:

* [spring-toml-property-source]() contains the library itself
* [spring-toml-property-source-example]() contains a demo Spring application that 
makes use of the library

## Usage

1. Add the library as a dependency. You can find it in the Maven Central repository.
For gradle users, simply add the following:

```groovy
implementation 'com.omarassadi:spring-toml-property-source:1.0.0'
```

2. Register the property source loader with Spring. You can do this by creating a file
in the `META-INF/` directory called `spring.factories` and adding the following line:

```properties
org.springframework.boot.env.PropertySourceLoader=com.omarassadi.spring.tomlpropertysource.TomlPropertySourceLoader
```

3. In your `resources/` directory, create file named `application.toml`. In that file,
you can configure your Spring application as you would have using standard
`application.properties` or `application.yml` files. 


Alternatively, you may mark a class with the added `@TomlPropertySource` annotation.
This works identically to the `@PropertySource` annotation that is bundled with 
Spring, except that it loads TOML rather than standard `.properties` files.
