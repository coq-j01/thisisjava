package ch04.practice;

public class prac03 {

	public static void main(String[] args) {
		// 4장 연습문제 3번 : for문으로 1~100까지의 정수 중 3의 배수 총합 구하기
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
