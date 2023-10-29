package dev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TapeReader {
	
	@Autowired // 의존성을 자동으로 연결해주는 옵션
	private Tape tape;

	public void test() {

		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 정상 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기 당했습니다");
		}
	}
	
	

	public TapeReader(Tape tape) {
		super();
		this.tape = tape;
	}



	@Override
	public String toString() {
		return "TapeReader 입니다.";
	}

}
