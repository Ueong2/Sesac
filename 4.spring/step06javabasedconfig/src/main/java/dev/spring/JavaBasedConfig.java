package dev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 .java 파일을 bean 설정 정보파일로 사용하겠다 라는 의미
@ComponentScan(basePackages = "dev.spring")
// -> xml 기반 설정 파일에서 <context:component-scan base-package="dev.spring" />과 
// 같다.
public class JavaBasedConfig { // bean 설정 정보가 기록된 파일
	// bean에 대한 정보를 작성
	
	@Bean
	public TapeReader tapeReader(Tape tape) {
		return new TapeReader(tape);
	}
	
	/*
	 * 기존에 xml에서 이렇게 작성했던 것들이 위의 코드처럼 간소화 됨
	 * <bean id="tapeReader" class="dev.spring.step02..TapeReader>
	 * 	<constructor-arg ref="tape />
	 * </bean>
	 */
	
}
