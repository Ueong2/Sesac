//package dev.spring.step02factory;
//
//public class TapeReaderFactory {
//	public static void main(String[] args) {
//		/*
//		 * My Room에서 TapeReader에 대한 의존성을 낮추는 방법
//		 * -> MyRoom에서 new를 사용하지 않고, TapeReader를 생성하여 사용하는 방법
//		 */
//		
//		// 새로 구매한 비디오 테이프를 테스트하기 위해 테이프 리더를 생성
//		TapeReader reader = TapeReaderFactory.createTapeReader();
//		
//		// 테스트 수행
//		reader.test();
//	}
//}
