package ch07.sec02;

public class SmartPhone extends Phone {
	//필드 선언
	public boolean wifi;

	//생성자 선언
	public SmartPhone(String model, String color) {
//		this.model = model;
//		this.color = color;
		//만약 생성자에 내용이 없으면
		//super();를 통해 부모의 생성자를 실행
		super(model,color);
	}

	//메소드 선언
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}

	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
}