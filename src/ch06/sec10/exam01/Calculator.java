package ch06.sec10.exam01;

public class Calculator {
	static double pi = 3.14159;
//	double pi = 3.14159;
	int a=10; //멤버변수

	static int plus(int x, int y) {
//		this.pi = 20.0; // this 호출 불가
//		a = 20; // 멤버변수 호출 불가
		return x + y;
	}
	
	static int minus(int x, int y) {
		return x - y;
	}
//	int plus(int x, int y) {
//		return x + y;
//	}
//	
//	int minus(int x, int y) {
//		return x - y;
//	}
}