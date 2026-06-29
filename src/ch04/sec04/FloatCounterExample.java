package ch04.sec04;

public class FloatCounterExample {
	public static void main(String[] args) {
		System.out.println("안녕하세요 1");
		System.out.println("안녕하세요 2");
		System.out.println("안녕하세요 3"); // 반복되는 행동을 할때 전부하기엔 비효율적
		
		for(int i=0; i<=30; i++) {
			System.out.println("안녕하세요 " + i);
		}
		
		for(float x=0.1f; x<=1.0f; x+=0.1f) {
			System.out.println(x);
		}
	}
}