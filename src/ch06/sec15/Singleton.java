package ch06.sec15;

public class Singleton {
	//private 접근 권한을 갖는 정적 필드 선언과 초기화
	private static Singleton singleton = new Singleton();

	//private 접근 권한을 갖는 생성자 선언
	private Singleton() { //선언하지 않으면 자동으로 public인 생성자가 생성되어 
	}                //		싱글톤에 맞지 않음

	//public 접근 권한을 갖는 정적 메소드 선언
	public static Singleton getInstance() {
		return singleton;
	}
}