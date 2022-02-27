监控控制台is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)

1. SpringBoot项目，引入：
```xml
<dependency>
    <groupId>com.github.dreamroute</groupId>
    <artifactId>bbp-monitor-spring-boot-starter</artifactId>
    <version>最新版本</version>
</dependency>
```

2. 在logback/logback-spring.xml中增加：
```xml
<root level="info">
    <!-- bbp monitor -->
    <appender name="MONITOR" class="com.github.dreamroute.bbp.monitor.spring.boot.starter.BeanPostProcessorMonitor"/>
</root>
```

3. 完成接入