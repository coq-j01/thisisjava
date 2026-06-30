package ch05.practice;

public class prac07 {
	public static void main(String[] args) {
		// 5장 연습문제 7번 : 배열에서 최대값 출력
		int[] array = { 1, 5, 3, 8, 2 };
		int max = 0;
		for (int num : array) {
			if (num > max)
				max = num;
		}
		System.out.println("최대값 : " + max);
	}
}
