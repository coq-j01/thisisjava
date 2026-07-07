package ch14.sec03.exam02;

import java.awt.Toolkit;

class BeepThread extends Thread{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}
public class BeepPrintExample0 {
	public static void main(String[] args) {
		//스레드 생성
		BeepThread thread = new BeepThread();
		//스레드 시작
		thread.start();
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}