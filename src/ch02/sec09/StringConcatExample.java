package ch02.sec09;

public class StringConcatExample {
	public static void main(String[] args) {
		//숫자 연산
		int result1 = 10 + 2 + 8; //20
		System.out.println("result1: " + result1);

		//결합 연산
		String result2 = 10 + 2 + "8"; //숫자 12와 문자 8 -> 12 문자로 변형되어 128 출력
		System.out.println("result2: " + result2);

		String result3 = 10 + "2" + 8; // "10" + "2" + "8" -> 1028
		System.out.println("result3: " + result3);

		String result4 = "10" + 2 + 8; // "10" + "2" + "8" ->1028 -> 왼쪽에서부터 식이 진행되기 때문
		System.out.println("result4: " + result4);

		String result5 = "10" + (2 + 8); // "10" + "10" ->1010
		System.out.println("result5: " + result5);
	}
}