package ch04.practice;

import java.util.Scanner;

public class prac07 {

	public static void main(String[] args) {
		// 4장 연습문제 7번 : 키보드로 입력받아 예금,출금,조회,종료 기능 제공하는 코드
		Scanner scanner = new Scanner(System.in);
		int balance = 0;
		while (true) {
			System.out.println("-------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4. 종료");
			System.out.println("-------------------------------");
			System.out.print("선택 > ");
			String select = scanner.nextLine();
			switch (select) {
			case "1" -> {
				System.out.print("예금액 > ");
				String in = scanner.nextLine();
				balance += Integer.parseInt(in);
			}
			case "2" -> {
				System.out.print("출금액 > ");
				String out = scanner.nextLine();
				int intout = Integer.parseInt(out);
				if(balance>= intout) balance -= intout;
			}
			case "3" -> System.out.println("잔고 > " + balance);
			case "4" -> {
				System.out.println("프로그램 종료");
				break;
			}
			}
		}
	}
}
