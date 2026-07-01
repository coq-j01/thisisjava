package ch07.sec02;

public class Phone {
	//필드 선언
//	public String model;
//	public String color;
	//private으로 변경
	private String model;
	private String color;
	
	public Phone(String model, String color) {
		this.model = model;
		this.color = model; //private변경 시 자식이 접근 불가함으로
							// 부모에 생성자 추가
	}

	//메소드 선언
	public void bell() {
		System.out.println("벨이 울립니다.");
	}

	public void sendVoice(String message) {
		System.out.println("자기: " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}

	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	//private 변경으로 getter 만들기
	public String getmodel() {
		return model;
	}
	public String getcolor() {
		return color;
	}
}