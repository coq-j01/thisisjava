package ch05.sec07;

public class ExamArr {

	public static void main(String[] args) {
		// 한 반의 점수 = 1차원 배열
//		int[] scores = new int[20];
//
//		for (int i = 0; i < scores.length; i++) {
//			scores[i] = (int) (Math.random() * 101); // 0점~100점 랜덤
//		}
//		// 20명 점수 출력
//		for (int score : scores) {
//			System.out.println(score + "점");
//		}
//		// 20명 점수 평균
//		int sum = 0;
//		for (int score : scores) {
//			sum += score;
//		}
//		double avg = (double) sum / scores.length;
//		System.out.println("총점 = " + sum + "점");
//		System.out.println("평균 = " + avg + "점");

		// 여러반의 점수 = 2차원배열
		int[][] scores = new int[5][20]; // 5개의 반, 반마다 20명의 학생
//		for (int i = 0; i < scores.length; i++) {
//			for (int j = 0; j < scores[i].length; j++) {
//				scores[i][j] = (int) (Math.random() * 101); // 0점~100점 랜덤
//				System.out.println(scores[i][j] + "점"); // 점수 출력
//			}
//		}
		// 각 반 20명 총점, 평균
//		int totalSum = 0;
//		int totalCount = 0;
//		for (int i = 0; i < scores.length; i++) {
//			int sum = 0;
//			totalCount += scores[i].length;
//			for (int j = 0; j < scores[i].length; j++) {
//				sum += scores[i][j];
//			}
//			totalSum += sum;
//			double avg = (double) sum / scores[i].length;
//
//			System.out.println((i + 1) + "반 총점 = " + sum + "점");
//			System.out.println((i + 1) + "반 평균 = " + avg + "점");
//		}
//		double totalAvg = (double) totalSum / totalCount;
//
//		System.out.println("전체 총점 = " + totalSum + "점");
//		System.out.println("전체 평균 = " + totalAvg + "점");

		// for-each 문
		for (int[] arr : scores) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) (Math.random() * 101);
			}
		}
		// 점수 출력
		for (int[] arr : scores) {
			for (int score : arr) {
				System.out.print(score + ", ");
			}
			System.out.println();
		}
		// 각 반 20명 총점, 평균
		int totalSum = 0;
		int totalCount = 0;
		for (int[] arr : scores) {
			int sum = 0;
			totalCount += arr.length;
			for (int score : arr) {
				sum += score;
			}
			totalSum += sum;
			double avg = (double) sum / arr.length;

			System.out.println("반 총점 = " + sum + "점");
			System.out.println("반 평균 = " + avg + "점");
		}
		double totalAvg = (double) totalSum / totalCount;

		System.out.println("전체 총점 = " + totalSum + "점");
		System.out.println("전체 평균 = " + totalAvg + "점");
	}

}
