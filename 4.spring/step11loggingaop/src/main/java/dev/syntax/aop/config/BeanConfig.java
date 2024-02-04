package dev.syntax.aop.config;

// Bean 설정 파일, 구성 정보를 담고 있는 Java 기반의 설정 파일

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "dev.syntax.aop")
@EnableAspectJAutoProxy
public class BeanConfig {
}
