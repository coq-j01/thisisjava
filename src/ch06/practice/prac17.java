package ch06.practice;

// 6강 학습문제 17번
class Printer2{
	static void println(int input) {
		System.out.println(input);
	}
	static void println(boolean input) {
		System.out.println(input);
	}
	static void println(double input) {
		System.out.println(input);
	}
	static void println(String input) {
		System.out.println(input);
	}
}

public class prac17 {
	public static void main(String[] args) {
		Printer2.println(10);
		Printer2.println(true);
		Printer2.println(5.7);
		Printer2.println("홍길동");
	}
}
