package dev.summer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrinkTest {

	public static void main(String[] args) {
		
		// 1. 별도의 XML 설정 파일 없이, Annotation 기반으로 빈을 등록하고, 컨테이너를 생성. base package만 적어주면 됨
		ApplicationContext context = new AnnotationConfigApplicationContext("dev.summer"); // base package


		Drink drink = context.getBean(Drink.class);
		System.out.println(drink);
	}
}
