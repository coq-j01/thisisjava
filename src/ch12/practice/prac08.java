package ch12.practice;

//12강 확인문제 8
//코드 실행시간 구하기
public class prac08 {
	public static void main(String[] args) {
		long time1 = System.nanoTime();
		int[] scores = new int[1000];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = i;
		}
		int sum = 0;
		for (int score : scores) {
			sum += score;
		}
		double avg = sum / scores.length;
		System.out.println(avg);
		long time2 = System.nanoTime();
		System.out.println("코드 실행에 걸린 시간(나노초) : " + (time2 - time1));
	}
}
