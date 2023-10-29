package dev.spring.step02factory;

public class TapeReader {
   Tape tape;   // TapeReader ->(의존, dependent) Tape
   static TapeReader tapeReader = new TapeReader();
   
   // 구매한 Tape가 정상 동작하는지 테스트
   public void test() {
      tape = new Tape("아일랜드", true);
      
      if(tape.isWorked) {
         System.out.println(tape.getName()+ "정상 동작합니다.");
      }else {
         System.out.println(tape.getName()+ "당하셨습니다..");
      }
   }
   
   public static TapeReader getTapeReader() {
      return tapeReader;
   }

}
