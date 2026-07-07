package ch13.sec02.exam03;

public class GenericExample {
	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		box1.content = "100";

		Box<String> box2 = new Box<>();
		box2.content = "100";
		
//		Box<Integer> box3 = new Box<>(); //box3은 타입이 달라 비교 에러남
		Box box3 = new Box(); // 비교하기위해 타입 제거
		box3.content = 100;

		boolean result1 = box1.compare(box2);
		System.out.println("result1: " + result1);

		boolean result2 = box1.compare(box3); 
		System.out.println("result2: " + result2);
	}
}