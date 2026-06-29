package ch04.practice;

public class prac06 {

	public static void main(String[] args) {
		// 4장 연습문제 6번 : 별 찍기
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
