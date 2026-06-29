package ch04.practice;

public class prac04 {

	public static void main(String[] args) {
		// 4장 연습문제 4번 : 두 개의 주사위 값 출력, 두 눈의 합 5일때 실행 멈추기
		int dice1 = 0, dice2 = 0;
		while (dice1 + dice2 != 5) {
			dice1 = (int) (Math.random() * 6 + 1);
			dice2 = (int) (Math.random() * 6 + 1);
			System.out.println("주사위 눈의 값 : (" + dice1 + "," + dice2 + ")");
		}
	}

}
