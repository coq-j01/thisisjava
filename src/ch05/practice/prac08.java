package ch05.practice;

public class prac08 {

	public static void main(String[] args) {
		// 5장 연습문제 8번 : 배열의 전체 합과 평균 구하기
		int[][] array = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		int sum=0;
		int count=0;
		for(int i=0; i<array.length; i++) {
			count += array[i].length;
			for(int j=0; j<array[i].length; j++) {
				sum+=array[i][j];
			}
		}
		double avg = (double)sum / count;
		System.out.println("전체 합 : "+sum);
		System.out.println("전체 평균 : "+avg);
	}

}
