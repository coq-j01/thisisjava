package ch04.practice;

public class prac02 {

	public static void main(String[] args) {
		// 4장 연습문제 2번 : switch문 expression(표현식)으로 바꾸기
		String grade = "B";

		int score1 = 0;
		switch (grade) {
		case "A" -> score1 = 100;
		case "B" -> {
			int result = 100 - 20;
			score1 = result;
		}
		default -> score1 = 60;
		}
		System.out.println("score = "+score1);
	}

}
