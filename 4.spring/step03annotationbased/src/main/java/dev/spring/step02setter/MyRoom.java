package dev.spring.step02setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		
		// 1. XML 파일을 사용하지만 Annotation이 적용되어 보다 간소화된 방식
		// field 기반 주입
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation-config-field.xml");
		
		// 스프링 컨테이너를 생성하면서 설정 정보가 담긴 xml 파일을 전달
		
		TapeReader reader = context.getBean(TapeReader.class);
		System.out.println(reader);
		// 테스트 수행
		reader.test();
		
	}

}
