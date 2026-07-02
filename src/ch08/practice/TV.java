package ch08.practice;

//8강 학습문제 5
interface Remocon{
	public void powerOn();
}

public class TV implements Remocon {
	@Override
	public void powerOn() {
		System.out.println("TV를 켰습니다.");
	}
	public static void main(String[] args) {
		Remocon r = new TV();
		r.powerOn();
	}
	
}
