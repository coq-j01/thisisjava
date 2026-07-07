package ch14.sec06.exam01;

public class SynchronizedExample {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		// calculator.memory = 0

		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		// calculator.memory = 100
		// user1Thread 내부에서 2초 대기 후 memory 값 출력
		// 예상 출력 결과 -> calculator.memory = 100

		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
		// calculator.memory = 50
		// user2Thread 내부에서 2초 대기 후 memory 값 출력
		// 예상 출력 결과 -> calculator.memory = 50
		
		//출력 결과
		//User1Thread: 50
		//User2Thread: 50 --> 동시에 사용이 되어 생기는 문제
		// 이 문제  해결하려면 실행하는 동안 아무도 못 쓰게 잠궈둬야함 -> synchronized 사용
	}
}