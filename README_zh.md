# Spring TOML Property Source

Spring TOML Property Source 会增加对你的 Spring Boot 项目中 TOML 配置文件加载的支持。

这个项目分为两部分：

* [spring-toml-property-source]() 包含了该库本身
* [spring-toml-property-source-example]() 包含了一个测试该库使用的 Spring 项目

## 应用

1. 添加该库为依赖项。你可以从 Maven Central 仓库中找到该库。
对于 gradle 用户，添加下列内容即可：

```gradle
implementation 'com.omarassadi:spring-toml-property-source:1.0.0'
```

2. 将 property source loader 加入到 Spring 中。为此你可以在 `META-INF/` 路径下创建一个名为 `spring.factories` 的文件，并在其中加入下列内容：

```properties
org.springframework.boot.env.PropertySourceLoader=com.omarassadi.spring.tomlpropertysource.TomlPropertySourceLoader
```

3. 在 `resources/` 路径下，创建一个名为 `application.toml` 的文件。在该文件中，你可以如同在一般的 `application.properties` 或 `application.yml` 文件中一样进行对你的 Spring 应用的设置。


或者，你可以为某个 class 添加 `@TomlPropertySource` 注解。
和 Spring 自带的 `@PropertySource` 注解一样，不过此注解会加载 TOML 文件而不是 `.properties` 文件。