package dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyRoom {

	public static void main(String[] args) {
		
		// 1. 별도의 XML 설정 파일 없이, Annotation 기반으로 빈을 등록하고, 컨테이너를 생성. base package만 적어주면 됨
		ApplicationContext context = new AnnotationConfigApplicationContext("dev.spring"); // base package
		
		// 스프링 컨테이너를 생성하면서 설정 정보가 담긴 xml 파일을 전달
		String[] beanNames = context.getBeanDefinitionNames();
		
		for (String beanName : beanNames) {
			Object bean = context.getBean(beanName);
			System.out.println("beanName : " + beanName + ", bean : " + bean);
		}

		TapeReader reader = context.getBean(TapeReader.class);
		System.out.println(reader);
		// 테스트 수행
		reader.test();	
	}
}
