package dev.spring.step01dependency;

public class MyRoom {

	public static void main(String[] args) {
		// 새로 구매한 비디오 테이프를 테스트하기 위해 테이프 리더를 생성
		TapeReader reader = new TapeReader();
		
		// 테스트 수행
		reader.test();
		
	}

}
