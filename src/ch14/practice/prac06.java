package ch14.practice;

//14강 확인문제 6
class MovieThread2 extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("동영상을 재생합니다.");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}

public class prac06 {
	public static void main(String[] args) {
		Thread thread = new MovieThread2();
		thread.setDaemon(true);
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		thread.interrupt();
	}
}