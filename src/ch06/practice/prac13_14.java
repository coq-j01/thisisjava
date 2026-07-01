package ch06.practice;

//6강 확인문제
 class Member {
	// 13번 : Member클래스의 필드 선언
	String name;
	String id;
	String password;
	int age;
	// 14번 : 생성자 추가
	Member(String name, String id){
		this.name = name;
		this.id = id;
	}
}

public class prac13_14 {
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
	}
}
