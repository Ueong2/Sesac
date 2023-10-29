package dev.spring.step02setter;

import org.springframework.beans.factory.annotation.Value;

public class Tape {
	@Value("아일랜드") private String name; // 필드 기반 기본 값 지정
	@Value("true") private boolean isWorked; // true, false로 바꿔보기
	// 이렇게 필드에서 값을 입력할 수도 있다.

	public Tape() {
		super();
		System.out.println("step01field Tape() called");
	}

	public Tape(String name, boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName() called");
		this.name = name;
	}

	public boolean isWorked() {
		return isWorked;
	}

	public void setWorked(boolean isWorked) {
		System.out.println("setWorked() called");
		this.isWorked = isWorked;
	}

}
