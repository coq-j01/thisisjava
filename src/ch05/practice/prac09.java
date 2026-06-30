package ch05.practice;

import java.util.Scanner;

public class prac09 {
	public static void main(String[] args) {
		// 5장 연습문제 9번 : 키보드로 학생 수와 각 학생들의 점수를 입력 받아
		// 최고 점수와 평균 점수 출력
		Scanner scanner = new Scanner(System.in);
		int max = 0;
		int sum = 0;
		int students = 0;
		int score[] = null;
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택 > ");
			int num = scanner.nextInt();
			switch (num) {
			case 1 -> {
				System.out.print("학생 수 > ");
				students = scanner.nextInt();
			}
			case 2 -> {
				if (students == 0) {
					System.out.println("학생 수가 0명입니다.");
					continue;
				}
				max = 0;
				sum = 0;
				score = new int[students];
				for (int i = 0; i < students; i++) {
					System.out.print("score[" + i + "] > ");
					score[i] = scanner.nextInt();
					sum += score[i];
					if (score[i] > max)
						max = score[i];
				}
			}
			case 3 -> {
				if (score == null) {
					System.out.println("점수가 입력되지 않았습니다.");
					continue;
				}
				for (int i = 0; i < students; i++) {
					System.out.println("score[" + i + "] : " + score[i]);
				}
			}
			case 4 -> {
				if (score == null) {
					System.out.println("점수가 입력되지 않았습니다.");
					break;
				}
				double avg = (double) sum / students;
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + avg);
			}
			case 5 -> {
				System.out.println("프로그램 종료");
				run = false;
			}
			}
		}
	}

}
