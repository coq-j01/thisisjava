package ch04.sec02;

public class ExamFunc {
	//함수 선언
	static int add(int x , int y) {
		System.out.println("x = "+x);
		System.out.println("y = "+y);
		return x + y;
	}
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		//int result = a + b;
		//위 result 계산을 함수를 통해 하기
		int result = add(a,b); //함수호출
		
		System.out.println("result = "+result);
	
	}
}
