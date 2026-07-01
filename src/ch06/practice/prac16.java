package ch06.practice;

//6강 학습문제 16
class Printer{
	
	void println(int input) {
		System.out.println(input);
	}
	void println(boolean input) {
		System.out.println(input);
	}
	void println(double input) {
		System.out.println(input);
	}
	void println(String input) {
		System.out.println(input);
	}
}

public class prac16 {
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동");
	}
}
