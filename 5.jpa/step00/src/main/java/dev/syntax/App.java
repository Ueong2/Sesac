package dev.syntax;

import dev.syntax.model.Major;
import dev.syntax.model.Student;

public class App {
	public static void main(String[] args) {
		/**
		 * 객체 지향 패러다임만으로 작성하는 코드
		 */
		
		// 학생 2명 인스턴스 생성
		Student kang = new Student(1, "정환");
		Student park = new Student(2, "형배");
		
		// CS 전공 인스턴스 생성
		Major major = new Major(1,"CS");
				
		// 두 학생에게 CS 전공을 추가
		kang.setMajor(major);
		park.setMajor(major);
		
		// 특정 학생의 전공이 무엇인지 확인하는 코드
		Major whoseMajor = kang.getMajor();
		System.out.println(whoseMajor);
		
	}

}
