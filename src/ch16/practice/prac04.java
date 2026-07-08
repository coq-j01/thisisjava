package ch16.practice;
//16강 확인문제 4
public class prac04 {
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			System.out.println("작업스레드가 실행됩니다.");
			System.out.println("작업스레드가 실행됩니다.");
			System.out.println("작업스레드가 실행됩니다.");
		});
		thread.start();
	}
}
