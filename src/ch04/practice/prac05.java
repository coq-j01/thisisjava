package ch04.practice;

public class prac05 {

	public static void main(String[] args) {
		// 4장 연습문제 5번 : 중첩 for문으로 4x + 5y = 60이 되는 모든 해 구하기
		// 이 때, x,y는 10이하 자연수
		int x, y;
		for (x = 1; x <= 10; x++) {
			for (y = 1; y <= 10; y++) {
				int result = 4 * x + 5 * y;
				if (result == 60) {
					System.out.println("(" + x + "," + y + ")");
				}
			}
		}
	}
}
